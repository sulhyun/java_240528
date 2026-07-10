package com.springmvc.boot8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springmvc.boot8.web.validation.ItemValidator;

@SpringBootApplication
public class Boot8Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Boot8Application.class, args);
	}
	
	/*
	// 글로벌 설정 - 모든 컨트롤러에 다 적용
	@Override
	public Validator getValidator() {
		return new ItemValidator();
	}
	*/

}
