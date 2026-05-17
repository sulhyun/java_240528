package com.core.boot3.order.service;

import com.core.boot3.order.domain.Order;

public interface OrderService {

	Order createOrder(Long memberId, String itemName, int itemPrice);
	
}