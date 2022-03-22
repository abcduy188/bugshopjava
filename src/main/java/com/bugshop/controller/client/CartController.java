package com.bugshop.controller.client;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CartDTO;
import com.bugshop.dto.CategoryDTO;
import com.bugshop.service.ICartService;
import com.bugshop.service.ICategoryService;

@Controller(value = "cartControllerOfClient")
public class CartController {
	
	@Autowired
	private ICartService iCartService;
	@Autowired
	private ICategoryService iCategoryService;

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView index() {
		CategoryDTO model = new CategoryDTO();
		model.setListResult(iCategoryService.listactive());
		ModelAndView mav = new ModelAndView("client/cart");
		mav.addObject("catelist", model);
		return mav;
	}
	@RequestMapping(value = "/add-cart/{id}", method = RequestMethod.GET)
	public String addCart(HttpSession session, @PathVariable Long id,HttpServletRequest request) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDTO>();
		}
		cart=iCartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" +request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/edit-cart/{id}/{quantity}", method = RequestMethod.GET)
	public String editCart(HttpSession session, HttpServletRequest request, @PathVariable Long id ,@PathVariable int quantity) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDTO>();
		}
		
		cart=iCartService.EditCart(id,quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" +request.getHeader("Referer");
	}
	@RequestMapping(value = "/delete-cart/{id}", method = RequestMethod.GET)
	public String deleteCart(HttpSession session,  @PathVariable Long id , HttpServletRequest request) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDTO>();
		}
		cart=iCartService.DeleteCart(id , cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" +request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/dat-hang", method = RequestMethod.GET)
	public ModelAndView checkout() {
		ModelAndView mav = new ModelAndView("client/checkout");
		return mav;
	}
}
