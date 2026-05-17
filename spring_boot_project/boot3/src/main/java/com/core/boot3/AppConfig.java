package com.core.boot3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.boot3.discount.DiscountPolicy;
import com.core.boot3.discount.RateDiscountPolicy;
import com.core.boot3.member.repository.MemberRepository;
import com.core.boot3.member.repository.MemoryMemberRepository;
import com.core.boot3.member.service.MemberService;
import com.core.boot3.member.service.MemberServiceImpl;
import com.core.boot3.order.service.OrderService;
import com.core.boot3.order.service.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
