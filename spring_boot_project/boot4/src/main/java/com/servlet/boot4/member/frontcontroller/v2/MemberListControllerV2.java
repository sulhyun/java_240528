package com.servlet.boot4.member.frontcontroller.v2;

import java.io.IOException;
import java.util.List;

import com.servlet.boot4.member.domain.Member;
import com.servlet.boot4.member.frontcontroller.MyView;
import com.servlet.boot4.member.repository.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		request.setAttribute("members", members);
		return new MyView("/WEB-INF/views/list.jsp");
	}

}
