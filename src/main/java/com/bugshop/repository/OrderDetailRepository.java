package com.bugshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.OrderDetailEntity;

public interface OrderDetailRepository  extends JpaRepository<OrderDetailEntity, Long>{

}
