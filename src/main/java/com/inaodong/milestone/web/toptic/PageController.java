package com.inaodong.milestone.web.toptic;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;
import com.inaodong.milestone.entity.User;
import com.inaodong.milestone.service.TopticService;
import com.inaodong.milestone.util.HttpServletRequestUtil;
import com.inaodong.milestone.util.ImageUtil;

	
@Controller
@RequestMapping(value="/page", method=RequestMethod.POST )
public class PageController {

	@Autowired
	private TopticService topticService;
	@ResponseBody
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public Map<String, Object> newPage(HttpServletRequest request){
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
		topticService.insertToptic(toptic,contentObject);
		
		
		return null;
	}
}
