package com.springmvc.boot05.basic.request;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.boot05.basic.Data;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {

	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		log.info("username: {}, age: {}", username, age);
		
		response.getWriter().write("ok");
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(@RequestParam("username") String username, @RequestParam("age") int age) {
		log.info("username: {}, age: {}", username, age);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(@RequestParam String username, @RequestParam int age) {
		log.info("username: {}, age: {}", username, age);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {
		log.info("username: {}, age: {}", username, age);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam( required = false) Integer age) {
		log.info("username: {}, age: {}", username, age);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username, @RequestParam(required = false, defaultValue = "-1") int age) {
		log.info("username: {}, age: {}", username, age);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
		log.info("username: {}, age: {}", paramMap.get("username"), paramMap.get("age"));
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@ModelAttribute Data data) {
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(Data data) {
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		return "ok";
	}
	
}
