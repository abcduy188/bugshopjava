package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Service;

import com.bugshop.converter.CategoryConverter;
import com.bugshop.converter.ProductConverter;
import com.bugshop.dto.ProductDTO;
import com.bugshop.dto.ProductPage;
import com.bugshop.entity.CategoryEntity;
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

		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();

		List<ProductDTO> models = new ArrayList<>();
		for (ProductEntity item : entities) {

			ProductDTO products = productConverter.toDto(item);
			products.setCategoryName(item.getCategory().getCategoryName().toString());
			models.add(products);
		}
		return models;
	}

	public ProductDTO findByID(Long id) {
		
		ProductDTO dto = productConverter.toDto(productRepository.findOne(id));
		return dto;
	}

	@Override
	@Transactional
	public int save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOne(dto.getCategoryId());

		ProductEntity productEntity = new ProductEntity();
		if (dto.getiD() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getiD());
			oldProduct.setCategory(category);
			productEntity = productConverter.toEntity(oldProduct, dto);
		} else {
			productEntity = productConverter.toEntity(dto);
			productEntity.setCategory(category);
		}

		productRepository.save(productEntity);
		return 1;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ProductEntity productEntity = productRepository.findOne(id);
		if (id != null) {
			productEntity.setIsDelete(true);
		}
		productConverter.toDto(productRepository.save(productEntity));

	}

	@Override
	public List<ProductDTO> productbycate(Long id) {
		List<ProductEntity> entities = productRepository.productbycate(id);
		List<ProductDTO> models = new ArrayList<>();
		for (ProductEntity item : entities) {

			ProductDTO products = productConverter.toDto(item);
			products.setCategoryName(item.getCategory().getCategoryName().toString());
			models.add(products);
		}
		return models;

	}

	@Override
	@Transactional
	public void activeStatus(Long id) {
		productRepository.activeStatus(id);
	}

	@Override
	@Transactional
	public void activeHighlights(Long id) {
		productRepository.activeHighlights(id);
		
	}

	@Override
	@Transactional
	public void unactiveStatus(Long id) {
		productRepository.unactiveStatus(id);
		
	}

	@Override
	@Transactional
	public void unactiveHighlights(Long id) {
		productRepository.unactiveHighlights(id);
		
	}

	@Override
	public List<ProductDTO> productsHighlights() {
		
		List<ProductEntity> entities = productRepository.productsHighlights();
		List<ProductDTO> models = new ArrayList<>();
		for (ProductEntity item : entities) {

			ProductDTO products = productConverter.toDto(item);
			products.setCategoryName(item.getCategory().getCategoryName().toString());
			models.add(products);
		}
		return models;
	}
	
	
	public Page<ProductEntity> listEntity(int pageNumber) {

		Pageable pageable = new PageRequest(pageNumber-1, 2);
		
		return productRepository.findAll(pageable);
	}

	@Override
	public List<ProductDTO> search(String keyword) {
		List<ProductEntity> entities = productRepository.search(keyword);
		List<ProductDTO> models = new ArrayList<>();
		for (ProductEntity item : entities) {

			ProductDTO products = productConverter.toDto(item);
			products.setCategoryName(item.getCategory().getCategoryName().toString());
			models.add(products);
		}
		return models;
	}



}
