package com.servlet.boot04.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/response-header
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Status Line
		response.setStatus(HttpServletResponse.SC_OK);	// 200
		
		// Response Header
		response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");
		
		// Header 편의 메소드
		content(response);
		cookie(response);
		redirect(response);
		
		// Message Body
		PrintWriter writer = response.getWriter();
		writer.println("ok");
	}
	
	// Content 편의 메서드
	private void content(HttpServletResponse response) {
		// Content-Type: text/plain;charset=utf-8
		// Content-Length: 2
		
		// 방법 1
		// response.setHeader("Content-Type", "text/plain;charset=utf-8");
		
		// 방법 2
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		// response.setContentLength(2); // (생략시 자동 생성)
	}
	
	// Cookie 편의 메서드
	private void cookie(HttpServletResponse response) {
		// Set-Cookie: myCookie=good; Max-Age=600;
		
		// 방법 1
		// response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600;");
		
		// 방법 2
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600);
		response.addCookie(cookie);
	}

	private void redirect(HttpServletResponse response) throws IOException {
		// Status Code 302
		// Location: /form.html
		
		// response.setStatus(HttpServletResponse.SC_FOUND);	// 302
		// response.setHeader("Location", "/form.html");
		
		response.sendRedirect("/form.html");
	}

}
