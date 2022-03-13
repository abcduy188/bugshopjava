package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bugshop.converter.UserConverter;
import com.bugshop.dto.UserDTO;
import com.bugshop.entity.RoleEntity;
import com.bugshop.entity.UserEntity;
import com.bugshop.repository.RoleRepository;
import com.bugshop.repository.UserRepository;
import com.bugshop.service.IUserService;

@Service
public class UserService implements IUserService {
	
	
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	RoleRepository roleRepository;
	
	@Autowired 
	UserConverter userConverter;
	@Override
	@Transactional
	public int register(UserDTO userDTO) {
		
		UserEntity entity = userRepository.findOneByEmail(userDTO.getEmail());
		if(entity != null)
		{
			return -1;
		}
		
		UserEntity user = new UserEntity();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(encode(userDTO.getPassword()));
		user.setRoles(Arrays.asList(roleRepository.findByCode("USER")));
		user.setStatus(1);
		userRepository.save(user);
		return 1;
		
		
	}
	private String encode(String pass)
	{
		
		String bcrypt = new BCryptPasswordEncoder().encode(pass);
		return bcrypt;
	}
	@Override
	public List<UserDTO> findAll() {
		
	        List<UserDTO> user = new ArrayList<>();
	        List<UserEntity> entities = userRepository.findAll();
	        entities.stream().forEach(entity -> {
	        	UserDTO studentDto = userConverter.toDto(entity);
	        	user.add(studentDto);
	        });
	        return user;
	    
	}
	
		
}
