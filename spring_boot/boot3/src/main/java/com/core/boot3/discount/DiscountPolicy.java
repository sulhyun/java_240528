package com.core.boot3.discount;

import com.core.boot3.member.domain.Member;

public interface DiscountPolicy {

	/***
	 * @return 할인 대상 금액
	 */
	int discount(Member member, int price);
	
}
