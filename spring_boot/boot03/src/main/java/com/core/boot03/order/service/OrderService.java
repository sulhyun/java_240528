package com.core.boot03.order.service;

import com.core.boot03.order.domain.Order;

public interface OrderService {

	Order createOrder(Long memberId, String itemName, int itemPrice);
	
}