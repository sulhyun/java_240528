package com.core.boot3.order.service;

import com.core.boot3.discount.DiscountPolicy;
import com.core.boot3.discount.FixDiscountPolicy;
import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemberRepository;
import com.core.boot3.member.repository.MemoryMemberRepository;
import com.core.boot3.order.Order;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
