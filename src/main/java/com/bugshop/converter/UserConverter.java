package com.bugshop.converter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bugshop.dto.UserDTO;
import com.bugshop.entity.ProductEntity;
import com.bugshop.entity.RoleEntity;
import com.bugshop.entity.UserEntity;

@Component
public class UserConverter {

	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setiD(entity.getID());
		result.setEmail(entity.getEmail());
		result.setName(entity.getName());
		result.setDelete(entity.isIsDelete());
		result.setCreateBy(entity.getCreateBy());
		result.setCreateDate(entity.getCreateDate());
		result.setModifiedBy(entity.getModifiedBy());
		result.setModifiedDate(entity.getModifiedDate());
		result.setRoles(entity.getRoles());
		result.setAddress(entity.getAddress());
		result.setPhone(entity.getPhone());
		Set<String> value = new HashSet<>();
		value = entity.getRoles().stream().map(RoleEntity::getCode).collect(Collectors.toSet());
		String[] array = value.toArray(new String[0]);
		result.setRoleString(array.toString());
		return result;
	}
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setAddress(dto.getAddress());
		result.setPhone(dto.getPhone());
		result.setName(dto.getName());
		return result;
	}
	
}
