package com.bugshop.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bugshop.dto.OrderDTO;
import com.bugshop.entity.OrderEntity;
import com.bugshop.entity.UserEntity;

@Component
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
	
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity result = new OrderEntity();
		result.setCreateDate(dto.getCreateDate());
		result.setShipping_name(dto.getShipping_name());
		result.setShipping_email(dto.getShipping_email());
		result.setShipping_address(dto.getShipping_address());
		result.setShipping_phone(dto.getShipping_phone());
		result.setOrder_code(dto.getOrder_code());
		result.setOrder_note(dto.getOrder_note());
		result.setShipping_type(dto.getShipping_type());
		return result;
	}
	public OrderEntity toEntity(OrderDTO dto,UserEntity user) {
		Date date = new Date();
		OrderEntity result = new OrderEntity();
		result.setCreateDate(date);
		result.setShipping_name(dto.getShipping_name());
		result.setShipping_email(dto.getShipping_email());
		result.setShipping_address(dto.getShipping_address());
		result.setShipping_phone(dto.getShipping_phone());
		result.setOrder_code(dto.getOrder_code());
		result.setOrder_note(dto.getOrder_note());
		result.setShipping_type(dto.getShipping_type());
		result.setUser(user);
		return result;
	}
}
