package com.inaodong.milestone.util;

import javax.servlet.http.HttpServletRequest;

public class CaptchaUtil {

	/**
	 * 验证码校验
	 * 
	 * @param request
	 * @return
	 */
	public static int checkCaptcha(HttpServletRequest request) {
		// 系统验证码
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 输入的验证码
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "captcha");
		if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			// 验证失败返回1
			return 1;
		}
		// 成功返回0
		return 0;

	}
}
