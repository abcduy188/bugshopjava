package com.bugshop.service;

import java.util.HashMap;

import com.bugshop.dto.CartDTO;

public interface ICartService {
	public HashMap<Long, CartDTO> AddCart(Long id, HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> EditCart(Long id,int qty ,HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> DeleteCart(Long id ,HashMap<Long, CartDTO> cart);
	public int TotalQuantity(HashMap<Long, CartDTO> cart);
	public double TotalPrice(HashMap<Long, CartDTO> cart);
}
