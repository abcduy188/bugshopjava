package com.bugshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
