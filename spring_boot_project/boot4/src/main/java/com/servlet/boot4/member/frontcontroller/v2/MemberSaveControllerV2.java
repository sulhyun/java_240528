package com.servlet.boot4.member.frontcontroller.v2;

import java.io.IOException;

import com.servlet.boot4.member.domain.Member;
import com.servlet.boot4.member.frontcontroller.MyView;
import com.servlet.boot4.member.repository.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		request.setAttribute("member", member);
		
		return new MyView("/WEB-INF/views/save.jsp");
	}

}
