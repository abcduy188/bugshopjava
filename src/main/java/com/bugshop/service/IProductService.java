package com.bugshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bugshop.dto.ProductDTO;
import com.bugshop.dto.ProductPage;
import com.bugshop.entity.ProductEntity;

public interface IProductService {
	List<ProductDTO> list();
	Page<ProductEntity> listEntity(int numberPage);
	List<ProductDTO> productbycate(Long id);
	List<ProductDTO> search(String keyword);
	int save(ProductDTO productDTO);
	ProductDTO findByID(Long id);
	void delete(Long id);
	
	void activeStatus (Long id);
	void activeHighlights(Long id);
	void unactiveStatus (Long id);
	void unactiveHighlights(Long id);
	List<ProductDTO> productsHighlights();
}
