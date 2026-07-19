package com.core.boot03.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.boot03.common.MyLogger;
import com.core.boot03.web.service.LogDemoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("controller test");
		logDemoService.logic("testId");
		return "OK";
	}
	
}
