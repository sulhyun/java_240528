package com.servlet.boot4.web.frontcontroller.v2;

import java.io.IOException;

import com.servlet.boot4.web.frontcontroller.MyView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerV2 {

	MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
