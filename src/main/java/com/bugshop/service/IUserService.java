package com.bugshop.service;

import java.util.List;

import com.bugshop.dto.UserDTO;
import com.bugshop.entity.UserEntity;

public interface IUserService {
	int register(UserDTO userDTO);
	List<UserDTO> findAll();
	UserDTO user(Long id);
	int save(UserDTO userDTO);
}
