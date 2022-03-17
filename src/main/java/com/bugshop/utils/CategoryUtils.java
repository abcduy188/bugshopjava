package com.bugshop.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bugshop.converter.CategoryConverter;
import com.bugshop.dto.CategoryDTO;
import com.bugshop.entity.CategoryEntity;
import com.bugshop.repository.CategoryRepository;

public class CategoryUtils {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;

	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();

		List<CategoryDTO> models = new ArrayList<>();
		for (CategoryEntity item : entities) {
			if (item.isIsDelete() == false && item.isStatus() == true) {
				CategoryDTO categoryDTO = categoryConverter.toDto(item);
				models.add(categoryDTO);
			}
		}
		return models;
	}
}
