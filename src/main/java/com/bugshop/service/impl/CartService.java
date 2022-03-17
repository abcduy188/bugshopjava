package com.bugshop.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.dto.CartDTO;
import com.bugshop.repository.Cart;
import com.bugshop.service.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private Cart cartd;

	@Override
	public HashMap<Long, CartDTO> AddCart(Long id, HashMap<Long, CartDTO> cart) {
		
		return cartd.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDTO> EditCart(Long id, int qty, HashMap<Long, CartDTO> cart) {
		
		return cartd.EditCart(id, qty, cart);
	}

	@Override
	public HashMap<Long, CartDTO> DeleteCart(Long id, HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartd.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuantity(HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartd.TotalQuantity(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartd.TotalPrice(cart);
	}

}
