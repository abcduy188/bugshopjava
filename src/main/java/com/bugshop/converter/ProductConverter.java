package com.bugshop.converter;

import org.springframework.stereotype.Component;

import com.bugshop.dto.ProductDTO;
import com.bugshop.entity.ProductEntity;
@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setiD(entity.getID());
		result.setName(entity.getName());
		result.setSeoTitle(entity.getSeoTitle());
		result.setDescription(entity.getDescription());
		result.setImage(entity.getImage());
		result.setPrice(entity.getPrice());
		result.setPromotionPrice(entity.getPromotionPrice());
		result.setQuantity(entity.getQuantity());
		result.setStatus(entity.isStatus());
		result.setDelete(entity.isIsDelete());
		result.setCreateBy(entity.getCreateBy());
		result.setCreateDate(entity.getCreateDate());
		result.setModifiedBy(entity.getModifiedBy());
		result.setModifiedDate(entity.getModifiedDate());
		result.setCategoryId(entity.getCategory().getID());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setSeoTitle(dto.getSeoTitle());
		result.setDescription(dto.getDescription());
		result.setImage(dto.getImage());
		result.setPrice(dto.getPrice());
		result.setPromotionPrice(dto.getPromotionPrice());
		result.setQuantity(dto.getQuantity());
		result.setStatus(dto.isStatus());
		result.setIsDelete(dto.isDelete());
		result.setCreateBy(dto.getCreateBy());
		result.setCreateDate(dto.getCreateDate());
		result.setModifiedBy(dto.getModifiedBy());
		result.setModifiedDate(dto.getModifiedDate());
		return result;
	}
}
