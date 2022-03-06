package com.bugshop.service;

import java.util.List;

import com.bugshop.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> list();
	int save(ProductDTO productDTO);
	ProductDTO findByID(Long id);
	void delete(Long id);
}
