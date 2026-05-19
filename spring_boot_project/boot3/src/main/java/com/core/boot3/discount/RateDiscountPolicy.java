package com.core.boot3.discount;

import org.springframework.stereotype.Component;

import com.core.boot3.member.domain.Grade;
import com.core.boot3.member.domain.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}

}
