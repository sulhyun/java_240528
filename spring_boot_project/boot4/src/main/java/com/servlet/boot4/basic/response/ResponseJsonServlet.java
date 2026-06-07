package com.servlet.boot4.basic.response;

import java.io.IOException;

import com.servlet.boot4.basic.HelloData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Content-Type: application/json
		response.setHeader("content-type", "application/json");
		response.setCharacterEncoding("utf-8");
		
		HelloData data = new HelloData();
		data.setUsername("Kim");
		data.setAge(20);
		
		// {"username" : "Kim", "age" : 20}
		String result = objectMapper.writeValueAsString(data);
		
		response.getWriter().write(result);
	}
	
}
