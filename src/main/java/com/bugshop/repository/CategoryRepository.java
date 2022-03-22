package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	@Query(value = "SELECT * FROM categoryproduct s WHERE s.IsDelete = 0 AND s.Status = 1" ,nativeQuery = true)
	public List<CategoryEntity> listactive();
}