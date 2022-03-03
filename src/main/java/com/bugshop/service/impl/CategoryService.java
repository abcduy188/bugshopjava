package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.converter.CategoryConverter;
import com.bugshop.dto.CategoryDTO;
import com.bugshop.entity.CategoryEntity;
import com.bugshop.repository.CategoryRepository;
import com.bugshop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;
	
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		List<CategoryDTO> models = new ArrayList<>();
		for (CategoryEntity item: entities)
		{
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			models.add(categoryDTO);
		}
		return models;
	}
}
