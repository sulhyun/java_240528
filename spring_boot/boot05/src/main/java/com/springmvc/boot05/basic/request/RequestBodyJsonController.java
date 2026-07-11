package com.springmvc.boot05.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.boot05.basic.Data;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Controller
public class RequestBodyJsonController {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("/request-body-json-v1")
	public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		log.info("messageBody: {}", messageBody);
		
		Data data = objectMapper.readValue(messageBody, Data.class);
		
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		
		response.getWriter().write("ok");
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v2")
	public String requestBodyJsonV2(@RequestBody String messageBody) {
		log.info("messageBody: {}", messageBody);
		
		Data data = objectMapper.readValue(messageBody, Data.class);
		
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v3")
	public String requestBodyJsonV3(@RequestBody Data data) {
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v4")
	public Data requestBodyJsonV4(@RequestBody Data data) {
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.getUsername(), data.getAge());
		
		return data;
	}
	
	@ResponseBody
	@PostMapping("/request-body-json-v5")
	public String requestBodyJsonV5(@RequestBody Map<String, Object> data) {
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.get("username"), data.get("age"));
		
		return "ok";
	}
	
	@PostMapping("/request-body-json-v6")
	public HttpEntity<String> requestBodyJsonV6(HttpEntity<Data> data) {
		log.info("data: {}", data);
		log.info("username: {}, age: {}", data.getBody().getUsername(), data.getBody().getAge());
		
		return new HttpEntity<>("ok");
	}
	
}
