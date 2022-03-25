package com.bugshop.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugshop.converter.ProductConverter;
import com.bugshop.dto.CartDTO;
import com.bugshop.dto.ProductDTO;

@Repository
public class Cart {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter productConverter;

	public HashMap<Long, CartDTO> AddCart(Long id, HashMap<Long, CartDTO> cart) { // id of product
		CartDTO itemCart = new CartDTO();

		ProductDTO product = findByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.getQuantity();
			itemCart.setQuantity(itemCart.getQuantity()+1);
			double total = 0;
			if (itemCart.getProducts().getPromotionPrice() != null) {
				total = itemCart.getProducts().getPromotionPrice();
			} else {
				total = itemCart.getProducts().getPrice();
			}
			itemCart.setTotalprice(total * itemCart.getQuantity());
		}
		else {
			itemCart.setProducts(product);
			itemCart.setQuantity(1);
			double total = 0;
			if (product.getPromotionPrice() != null) {
				total = product.getPromotionPrice();
			} else {
				total = product.getPrice();
			}
			itemCart.setTotalprice(total);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDTO> EditCart(Long id, int qty, HashMap<Long, CartDTO> cart) {
		if (cart == null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id); // tra ve 1 san pham co cung id
			itemCart.setQuantity(qty);
			double total = 0;
			if (itemCart.getProducts().getPromotionPrice() != null) {
				total = itemCart.getProducts().getPromotionPrice();
			} else {
				total = itemCart.getProducts().getPrice();
			}
			itemCart.setTotalprice(total * qty);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDTO> DeleteCart(Long id, HashMap<Long, CartDTO> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuantity(HashMap<Long, CartDTO> cart) {
		int totalquantity = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart .entrySet()) //lay ra 1 item trong list cart 
		{
			totalquantity+=itemCart.getValue().getQuantity();
		}
		
		return totalquantity;
	}

	public double TotalPrice(HashMap<Long, CartDTO> cart) {

		double totalPrice = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart .entrySet()) //lay ra 1 item trong list cart 
		{
			totalPrice+=itemCart.getValue().getTotalprice();
		}
		
		return totalPrice;
	}

	public ProductDTO findByID(Long id) {
		ProductDTO dto = productConverter.toDto(productRepository.findOne(id));
		return dto;
	}
}
