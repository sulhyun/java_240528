package com.core.boot03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.boot03.discount.DiscountPolicy;
import com.core.boot03.discount.RateDiscountPolicy;
import com.core.boot03.member.repository.MemberRepository;
import com.core.boot03.member.repository.MemoryMemberRepository;
import com.core.boot03.member.service.MemberService;
import com.core.boot03.member.service.MemberServiceImpl;
import com.core.boot03.order.service.OrderService;
import com.core.boot03.order.service.OrderServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public MemberService memberService() {
		// 1번
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		// 1번
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		// 2번? 3번?
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
	
}
