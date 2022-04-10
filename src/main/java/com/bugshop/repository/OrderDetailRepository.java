package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.OrderDetailEntity;

public interface OrderDetailRepository  extends JpaRepository<OrderDetailEntity, Long>{
	@Query(value = "SELECT * FROM order_detail s WHERE s.order_id = ?1", nativeQuery = true)
	List<OrderDetailEntity> findByOrder(Long id);
}
