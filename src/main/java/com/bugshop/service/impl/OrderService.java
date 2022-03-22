package com.bugshop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.converter.OrderConverter;
import com.bugshop.converter.ProductConverter;
import com.bugshop.dto.CartDTO;
import com.bugshop.dto.OrderDTO;
import com.bugshop.entity.OrderDetailEntity;
import com.bugshop.entity.OrderEntity;
import com.bugshop.entity.ProductEntity;
import com.bugshop.entity.UserEntity;
import com.bugshop.repository.OrderDetailRepository;
import com.bugshop.repository.OrderRepository;
import com.bugshop.repository.ProductRepository;
import com.bugshop.repository.UserRepository;
import com.bugshop.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	UserRepository userRepository;
	@Autowired 
	OrderConverter orderConverter;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductConverter productConverter;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public Long AddOrder(OrderDTO order) {
		UserEntity user = userRepository.findOne(order.getCustomer_id());
		OrderEntity entity = new OrderEntity();
		
		order.setOrder_code(getRandomNumberString());
		entity = orderConverter.toEntity(order, user);
		
		Long id = (orderRepository.save(entity)).getOrder_id();
		return id;
	}

	@Override
	public void AddOrderDetail(HashMap<Long, CartDTO> carts, Long id) {
		
		OrderEntity entity = orderRepository.findOne(id);
		for(Map.Entry<Long, CartDTO> itemCart: carts.entrySet()) {
			ProductEntity proentity = productRepository.findOne(itemCart.getValue().getProducts().getiD());
			OrderDetailEntity ord = new OrderDetailEntity();
			ord.setOrder(entity);
			ord.setProduct(proentity);
			ord.setProduct_price(itemCart.getValue().getTotalprice());
			ord.setProduct_name(itemCart.getValue().getProducts().getName());
			ord.setProduct_sales_quantity(itemCart.getValue().getQuantity());
			orderDetailRepository.save(ord);
		}
	}
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(99999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%05d", number);
	}
	
}
