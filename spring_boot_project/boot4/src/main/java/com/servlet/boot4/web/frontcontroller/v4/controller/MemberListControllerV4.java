package com.servlet.boot4.web.frontcontroller.v4.controller;

import java.util.List;
import java.util.Map;

import com.servlet.boot4.domain.Member;
import com.servlet.boot4.repository.MemberRepository;
import com.servlet.boot4.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		
		model.put("members", members);
		return "list";
	}

}
