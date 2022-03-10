package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByCode(String code);
}
