package com.servlet.boot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class Boot4Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot4Application.class, args);
	}

}
