package com.servlet.boot4.member.frontcontroller.v1;

import java.io.IOException;
import java.util.List;

import com.servlet.boot4.member.domain.Member;
import com.servlet.boot4.member.repository.MemberRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		
		request.setAttribute("members", members);
		
		String viewPath = "/WEB-INF/views/list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
}
