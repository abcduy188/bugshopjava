package com.bugshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
}