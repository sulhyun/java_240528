package kr.kh.boot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.kh.boot2.repository.MemberRepository;
import kr.kh.boot2.repository.MemoryMemberRepository;
import kr.kh.boot2.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

}