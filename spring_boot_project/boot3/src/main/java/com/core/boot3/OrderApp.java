package com.core.boot3;

import com.core.boot3.member.domain.Grade;
import com.core.boot3.member.domain.Member;
import com.core.boot3.member.service.MemberService;
import com.core.boot3.member.service.MemberServiceImpl;
import com.core.boot3.order.Order;
import com.core.boot3.order.service.OrderService;
import com.core.boot3.order.service.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService =  new OrderServiceImpl();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		System.out.println("order = " + order);
		System.out.println("order = " + order.calculatePrice());
		
	}
}
