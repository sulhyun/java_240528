package com.core.boot03.order.service;

import org.springframework.stereotype.Component;

import com.core.boot03.annotation.MainDiscountPolicy;
import com.core.boot03.discount.DiscountPolicy;
import com.core.boot03.member.domain.Member;
import com.core.boot03.member.repository.MemberRepository;
import com.core.boot03.order.domain.Order;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
