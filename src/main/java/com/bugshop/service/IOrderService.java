package com.bugshop.service;

import java.util.HashMap;

import com.bugshop.dto.CartDTO;
import com.bugshop.dto.OrderDTO;

public interface IOrderService {
	public Long AddOrder(OrderDTO order);
	
	public void AddOrderDetail(HashMap<Long, CartDTO> carts, Long id);
}
