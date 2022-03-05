package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.converter.CategoryConverter;
import com.bugshop.converter.ProductConverter;
import com.bugshop.dto.ProductDTO;
import com.bugshop.entity.ProductEntity;
import com.bugshop.repository.CategoryRepository;
import com.bugshop.repository.ProductRepository;
import com.bugshop.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter productConverter;
	
	
	public List<ProductDTO> list() {
		
		
		List<ProductEntity> entities = productRepository.findAll();

		List<ProductDTO> models = new ArrayList<>();
		for (ProductEntity item : entities) {
			
			
			ProductDTO products = productConverter.toDto(item);
			products.setCategoryName(item.getCategory().getCategoryName().toString());
			models.add(products);
		}
		return models;
	}
}
