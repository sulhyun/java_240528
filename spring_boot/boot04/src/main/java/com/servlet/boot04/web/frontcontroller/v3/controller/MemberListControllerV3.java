package com.servlet.boot04.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.servlet.boot04.domain.Member;
import com.servlet.boot04.repository.MemberRepository;
import com.servlet.boot04.web.frontcontroller.ModelView;
import com.servlet.boot04.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		List<Member> members = memberRepository.findAll();
		
		ModelView model = new ModelView("list");
		model.getModel().put("members", members);
		return model;
	}

}
