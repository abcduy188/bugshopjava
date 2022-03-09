package com.bugshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByEmailAndStatus(String email, int Status);
	UserEntity findOneByEmail(String email);
}
