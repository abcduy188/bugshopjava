package com.bugshop.service;

import java.util.List;

import com.bugshop.dto.UserDTO;

public interface IUserService {
	int register(UserDTO userDTO);
	List<UserDTO> findAll();
}
