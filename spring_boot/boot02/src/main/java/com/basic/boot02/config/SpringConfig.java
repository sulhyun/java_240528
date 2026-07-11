package com.basic.boot02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basic.boot02.repository.MemberRepository;
import com.basic.boot02.service.MemberService;


@Configuration
public class SpringConfig {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
	/*
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepositrory(dataSource);
		//return new JpaMemberRepository(em);
	}
	*/

}