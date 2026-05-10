package kr.kh.boot2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import kr.kh.boot2.repository.JdbcMemberRepository;
import kr.kh.boot2.repository.JdbcTemplateMemberRepositrory;
import kr.kh.boot2.repository.JpaMemberRepository;
import kr.kh.boot2.repository.MemberRepository;
import kr.kh.boot2.service.MemberService;

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
	
//	@Bean
//	public MemberRepository memberRepository() {
//		//return new MemoryMemberRepository();
//		//return new JdbcMemberRepository(dataSource);
//		//return new JdbcTemplateMemberRepositrory(dataSource);
//		//return new JpaMemberRepository(em);
//		
//	}

}