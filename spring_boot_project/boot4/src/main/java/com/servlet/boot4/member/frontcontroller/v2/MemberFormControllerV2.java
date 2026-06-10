package com.servlet.boot4.member.frontcontroller.v2;

import java.io.IOException;

import com.servlet.boot4.member.frontcontroller.MyView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new MyView("/WEB-INF/views/form.jsp");
	}

}
