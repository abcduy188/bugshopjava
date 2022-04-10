package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.OrderEntity;
import com.bugshop.entity.ProductEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	@Query(value = "SELECT * FROM tbl_order s WHERE s.customer_id = ?1", nativeQuery = true)
	public List<OrderEntity> findByUser(Long id);
	
	@Modifying
	@Query(value = "UPDATE tbl_order s SET s.order_status = 0 WHERE s.order_id = ?1", nativeQuery = true)
	public void cancelOrder(Long id);

	@Modifying
	@Query(value = "UPDATE tbl_order s SET s.order_status = 2 WHERE s.order_id	 = ?1", nativeQuery = true)
	public void acceptOrder(Long id);
}
