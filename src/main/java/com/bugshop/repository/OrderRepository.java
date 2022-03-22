package com.bugshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
