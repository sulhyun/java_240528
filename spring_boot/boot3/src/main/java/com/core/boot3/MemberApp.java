package com.core.boot3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.boot3.member.domain.Grade;
import com.core.boot3.member.domain.Member;
import com.core.boot3.member.service.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "MemberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
		
	}
}
