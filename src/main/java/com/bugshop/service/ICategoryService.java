package com.bugshop.service;

import java.util.List;

import com.bugshop.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	CategoryDTO findByID(Long id);
	void save(CategoryDTO categoryDTO);
	void delete(Long id);
}
