package com.bugshop.controller.client;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CartDTO;
import com.bugshop.service.ICartService;

@Controller(value = "cartControllerOfClient")
public class CartController {
	
	@Autowired
	private ICartService iCartService;

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("client/cart");
		return mav;
	}
	@RequestMapping(value = "/add-cart/{id}", method = RequestMethod.GET)
	public String addCart(HttpSession session, @PathVariable Long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDTO>();
		}
		cart=iCartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalPrice(cart));
		return "redirect:/trang-chu";
	}
}
