package com.springmvc.boot05.basic.response;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.boot05.basic.Data;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // @Controller + @ResponseBody
public class ResponseBodyController {

	@GetMapping("/response-body-string-v1")
	public void responseBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}
	
	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseBodyStringV2() {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@GetMapping("/response-body-string-v3")
	public String responseBodyStringV3() {
		return "ok";
	}
	
	@GetMapping("/response-body-json-v1")
	public ResponseEntity<Data> responseBodyJsonbV1() {
		Data data = new Data();
		data.setUsername("spring");
		data.setAge(20);
		
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/response-body-json-v2")
	public Data responseBodyJsonV2() {
		Data data = new Data();
		data.setUsername("spring");
		data.setAge(20);
		
		return data;
	}
	
}
