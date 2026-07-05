package com.servlet.boot4.web.frontcontroller.v5;

import java.io.IOException;

import com.servlet.boot4.web.frontcontroller.ModelView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

	boolean supports(Object handler);
	
	ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
	
}
