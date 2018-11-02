package com.inaodong.milestone.web.user;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inaodong.milestone.entity.User;
import com.inaodong.milestone.service.UserService;
import com.inaodong.milestone.util.CaptchaUtil;
import com.inaodong.milestone.util.ConstantField;
import com.inaodong.milestone.util.HttpServletRequestUtil;
import com.inaodong.milestone.util.PasswordUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public Map<String, Object> registerUser(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取json数据转换成实体类
		String jsonData = HttpServletRequestUtil.getString(request, "loginForm");
		User user = new User();

		try {
			user = mapper.readValue(jsonData, User.class);
		} catch (IOException e) {

			modelMap.put("result", false);
			modelMap.put("message", e.toString());
			return modelMap;
		}

		user.setUserType(ConstantField.NOT_ADMIN);
		Date now = new Date();
		user.setCreateTime(now);
		// 密码加密sha256生成64位密文
		user.setPassword(PasswordUtil.getSHA256(user.getPassword()));
		user.setStatus(ConstantField.IS_ACTIVE);
		int insertNum = userService.register(user);
		if (insertNum == 1) {
			modelMap.put("result", true);
		} else {
			modelMap.put("result", false);
		}
		return modelMap;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String username = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		User user = userService.login(username, PasswordUtil.getSHA256(password));
		if (user == null) {
			modelMap.put("result", false);
			modelMap.put("message", "用户名或密码错误");
			return modelMap;
		}
		request.getSession().setAttribute("user",user);
		request.getSession().setMaxInactiveInterval(30*60);
		modelMap.put("result", true);
		modelMap.put("message", "登录成功");
		return modelMap;
	}

	/**
	 * 参数校验
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public Map<String, Object> checkParam(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String paramType = request.getParameter("paramType");
		int result = 0;
		switch (paramType) {
		case "userName":
			result = userService.checkUserName(request.getParameter(paramType));
			if (result == 0) {
				modelMap.put("result", true);
			} else {
				modelMap.put("result", false);
				modelMap.put("message", "用户名已存在！");
			}
			break;
		case "captcha":
			result = CaptchaUtil.checkCaptcha(request);
			if (result == 0) {
				modelMap.put("result", true);
			} else {
				modelMap.put("result", false);
				modelMap.put("message", "验证码错误！");
			}
			break;
		case "email":
			result = userService.checkEmail(request.getParameter(paramType));
			if (result == 0) {
				modelMap.put("result", true);
				modelMap.put("message", "email");
			} else {
				modelMap.put("result", false);
				modelMap.put("message", "邮箱已被使用！");
			}
			break;
		case "nickName":
			result = userService.checkNickName(request.getParameter(paramType));
			if (result == 0) {
				modelMap.put("result", true);
			} else {
				modelMap.put("result", false);
				modelMap.put("message", "昵称已被占用！");
			}
			break;
		default:

		}
		return modelMap;
	}

}
