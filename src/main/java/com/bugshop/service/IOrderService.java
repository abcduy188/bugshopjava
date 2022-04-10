package com.bugshop.service;

import java.util.HashMap;
import java.util.List;

import com.bugshop.dto.CartDTO;
import com.bugshop.dto.OrderDTO;
import com.bugshop.entity.OrderDetailEntity;
import com.bugshop.entity.OrderEntity;

public interface IOrderService {
	public Long AddOrder(OrderDTO order);
	List<OrderEntity> findAll();
	public void AddOrderDetail(HashMap<Long, CartDTO> carts, Long id);
	List<OrderEntity> findByUser(Long id);
	List<OrderDetailEntity> findByOrder(Long id);
	OrderEntity findOne(Long id);
	void accept(Long id);
	void cancel(Long id);
}
