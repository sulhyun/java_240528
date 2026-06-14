package com.servlet.boot4.basic.request;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/***
 * 1. 피라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 * 
 * 2. 동일한 피라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&username=bye&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[전체 피라미터 조회]");
		// 방법 1
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			System.out.println(parameterName + ": " + request.getParameter(parameterName));
		}
		
		// 방법 2
		request.getParameterNames().asIterator().forEachRemaining(parameterName -> System.out.println(parameterName + ": " + request.getParameter(parameterName)));
		System.out.println();
		
		System.out.println("[단일 피라미터 조회]");
		String username = request.getParameter("username");
		System.out.println("request.getParameter(username): " + username);
		
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("request.getParameter(age): " + age);
		System.out.println();	
		
		System.out.println("[이름이 같은 복수 피라미터 조회]");
		System.out.println("request.getParameterValues(username)");
		String[] usernames = request.getParameterValues("username");
		for(String name : usernames) {
			System.out.println("username: " + name);
		}
		
		response.getWriter().write("ok");
	}
	
}
