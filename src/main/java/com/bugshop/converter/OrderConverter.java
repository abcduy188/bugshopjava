package com.bugshop.converter;

import com.bugshop.dto.OrderDTO;
import com.bugshop.entity.OrderEntity;

public class OrderConverter {
	public OrderDTO toDto(OrderEntity entity) {
		OrderDTO result = new OrderDTO();
		result.setCustomer_id(entity.getUser().getID());
		result.setOrder_id(entity.getOrder_id());
		result.setCreateDate(entity.getCreateDate());
		result.setShipping_name(entity.getShipping_name());
		result.setShipping_email(entity.getShipping_email());
		result.setShipping_address(entity.getShipping_address());
		result.setShipping_phone(entity.getShipping_phone());
		result.setOrder_code(entity.getOrder_code());
		result.setOrder_note(entity.getOrder_note());
		result.setShipping_type(entity.getShipping_type());
		return result;
	}
	
	public OrderEntity toEntity(OrderDTO entity) {
		OrderEntity result = new OrderEntity();
		result.setCreateDate(entity.getCreateDate());
		result.setShipping_name(entity.getShipping_name());
		result.setShipping_email(entity.getShipping_email());
		result.setShipping_address(entity.getShipping_address());
		result.setShipping_phone(entity.getShipping_phone());
		result.setOrder_code(entity.getOrder_code());
		result.setOrder_note(entity.getOrder_note());
		result.setShipping_type(entity.getShipping_type());
		return result;
	}
}
