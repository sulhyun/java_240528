package com.core.boot3;

import com.core.boot3.discount.RateDiscountPolicy;
import com.core.boot3.member.repository.MemoryMemberRepository;
import com.core.boot3.member.service.MemberService;
import com.core.boot3.member.service.MemberServiceImpl;
import com.core.boot3.order.service.OrderService;
import com.core.boot3.order.service.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
	}
}
