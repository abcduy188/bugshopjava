package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();

		List<CategoryDTO> models = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			models.add(categoryDTO);
		}
		return models;
	}

	public CategoryDTO findByID(Long id) {
		CategoryDTO dto = categoryConverter.toDto(categoryRepository.findOne(id));
		return dto;
	}

	@Override
	@Transactional
	public void save(CategoryDTO dto) {
		
		CategoryEntity categoryEntity = new CategoryEntity();
		
		if(dto.getiD()!= null) {
			CategoryEntity oldCate= categoryRepository.findOne(dto.getiD());
			categoryEntity = categoryConverter.toEntity(oldCate, dto);
		}
		else {
			categoryEntity = categoryConverter.toEntity(dto);
		}
		
		categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		CategoryEntity oldCate= categoryRepository.findOne(id);
		if(id!= null) {
			oldCate.setIsDelete(true);
		}
		categoryConverter.toDto(categoryRepository.save(oldCate));
	}
	
	@Override
	  public Map<Long, String> findAllbypr() {
		  Map<Long, String> result= new HashMap<>();
		  List<CategoryEntity> entities = categoryRepository.findAll();
		  
		  for( CategoryEntity item: entities)
		  {
			  if(item.isIsDelete() == false && item.isStatus() == true)
			  {
				  result.put(item.getID(), item.getCategoryName());
			  }
			  
		  }
		  return result;
	   }
	
	

}
