package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	@Query(value = "SELECT * FROM product s WHERE s.Status = true AND s.IsDelete= false AND s.category_id = ?1", nativeQuery = true)
	public List<ProductEntity> productbycate (Long id);
	@Modifying
	@Query(value = "UPDATE product s SET s.Status = true WHERE s.id = ?1", nativeQuery = true)
	public void activeStatus (Long id);
	@Modifying
	@Query(value = "UPDATE product s SET s.Status = false WHERE s.id = ?1", nativeQuery = true)
	public void unactiveStatus (Long id);
	@Modifying
	@Query(value = "UPDATE product s SET s.highlights = true WHERE s.id = ?1", nativeQuery = true)
	public void activeHighlights (Long id);
	@Modifying
	@Query(value = "UPDATE product s SET s.highlights = false WHERE s.id = ?1", nativeQuery = true)
	public void unactiveHighlights (Long id);
	
	@Query(value = "SELECT * FROM product s WHERE s.highlights = true AND s.Status = true AND s.IsDelete= false ORDER BY s.id LIMIT 6", nativeQuery = true)
	public List<ProductEntity> productsHighlights();
}
