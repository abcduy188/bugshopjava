package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	@Query(value = "SELECT * FROM product s WHERE s.category_id = ?1", nativeQuery = true)
	public List<ProductEntity> productbycate (Long id);
}
