package com.inaodong.milestone.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method = { RequestMethod.GET,
		RequestMethod.POST })
public class URLController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		return "register";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping("/new")
	public String newPage(HttpServletRequest request) {
		return "new";
	}
}
