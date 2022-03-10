package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bugshop.constant.SystemConstant;
import com.bugshop.dto.MyUser;
import com.bugshop.entity.RoleEntity;
import com.bugshop.entity.UserEntity;
import com.bugshop.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//check email+ passworld ngam/ check status
		UserEntity userEntity = userRepository.findOneByEmailAndStatus(email, SystemConstant.ACTIVE_STATUS);
		
		
		if(userEntity == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		
		//1 user co nhieu role => list
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getEmail(),userEntity.getName(), userEntity.getPassword(), true, true, true, true, authorities);
		
		myUser.setName(userEntity.getName());
		myUser.setEmail(userEntity.getEmail());
		
		return myUser;
	}

}
