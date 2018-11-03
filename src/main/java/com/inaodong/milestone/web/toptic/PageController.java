package com.inaodong.milestone.web.toptic;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inaodong.milestone.dto.PageInfo;
import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;
import com.inaodong.milestone.entity.User;
import com.inaodong.milestone.service.TopticService;
import com.inaodong.milestone.util.HttpServletRequestUtil;
import com.inaodong.milestone.util.ImageUtil;

/**
 * 发帖功能存在问题 图片处理问题
 *  查询帖子功能
 * @author SEELE
 *
 */
@Controller
@RequestMapping(value = "/page", method = RequestMethod.POST)
public class PageController {

	@Autowired
	private TopticService topticService;

	@ResponseBody
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public Map<String, Object> newPage(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String title = HttpServletRequestUtil.getString(request, "title");
		String content = HttpServletRequestUtil.getString(request, "content");
		int district = HttpServletRequestUtil.getInt(request, "district");
		User user = (User) request.getSession().getAttribute("user");
		Toptic toptic = new Toptic();
		toptic.setTitle(title);
		toptic.setCreateTime(new Date());
		toptic.setReplayTime(new Date());
		toptic.setDistrict(district);
		toptic.setUserId(user.getUserId());
		toptic.setStatus(1);
		Content contentObject = new Content();
		content = ImageUtil.base64ToImage(content);
		contentObject.setContent(content);
		int result = topticService.insertToptic(toptic, contentObject);
		if(result == 0) {
			modelMap.put("result", false);
			modelMap.put("message", "发帖失败");
		}else {
			modelMap.put("result", true);
		}

		return modelMap;
	}

	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Map<String, Object> queryPageList(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int currentPage = HttpServletRequestUtil.getInt(request, "currentPage") - 1;
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		List<PageInfo> pageInfoList = topticService.queryPageList(currentPage, pageSize);
		if (pageInfoList != null && pageInfoList.size() != 0) {
			modelMap.put("result", true);
			modelMap.put("pageInfoList", pageInfoList);
		} else {
			modelMap.put("result", false);
			modelMap.put("message", "查询帖子主题失败");
		}

		return modelMap;
	}
}
