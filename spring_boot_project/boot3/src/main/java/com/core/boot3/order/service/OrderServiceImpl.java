package com.core.boot3.order.service;

import org.springframework.stereotype.Component;

import com.core.boot3.discount.DiscountPolicy;
import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemberRepository;
import com.core.boot3.order.domain.Order;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
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
