package com.bugshop.converter;

import org.springframework.stereotype.Component;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setiD(entity.getID());
		result.setCategoryName(entity.getCategoryName());
		result.setParentID(entity.getParentID());
		result.setSeoTitle(entity.getSeoTitle());
		result.setStatus(entity.isStatus());
		result.setDelete(entity.isIsDelete());
		result.setCreateBy(entity.getCreateBy());
		result.setCreateDate(entity.getCreateDate());
		result.setModifiedBy(entity.getModifiedBy());
		result.setModifiedDate(entity.getModifiedDate());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setCategoryName(dto.getCategoryName());
		result.setParentID(dto.getParentID());
		result.setSeoTitle(dto.getSeoTitle());
		result.setStatus(dto.isStatus());
		result.setIsDelete(dto.isDelete());
		result.setCreateBy(dto.getCreateBy());
		result.setCreateDate(dto.getCreateDate());
		result.setModifiedBy(dto.getModifiedBy());
		result.setModifiedDate(dto.getModifiedDate());
		return result;
	}
}

