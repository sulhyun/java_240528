package com.servlet.boot04.web.frontcontroller.v3.controller;

import java.util.Map;

import com.servlet.boot04.domain.Member;
import com.servlet.boot04.repository.MemberRepository;
import com.servlet.boot04.web.frontcontroller.ModelView;
import com.servlet.boot04.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String username = paramMap.get("username");
		int age = Integer.parseInt(paramMap.get("age"));
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		ModelView model = new ModelView("save");
		model.getModel().put("member", member);
		return model;
	}

}
