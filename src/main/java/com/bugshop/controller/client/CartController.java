package com.bugshop.controller.client;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CartDTO;
import com.bugshop.dto.CategoryDTO;
import com.bugshop.dto.MyUser;
import com.bugshop.dto.OrderDTO;
import com.bugshop.service.ICartService;
import com.bugshop.service.ICategoryService;
import com.bugshop.service.IOrderService;
import com.bugshop.utils.SecurityUtils;

@Controller(value = "cartControllerOfClient")
public class CartController {

	@Autowired
	private ICartService iCartService;
	@Autowired
	private ICategoryService iCategoryService;
	@Autowired 
	private IOrderService iOrderService;

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView index() {
		CategoryDTO model = new CategoryDTO();
		model.setListResult(iCategoryService.listactive());
		ModelAndView mav = new ModelAndView("client/cart");
		mav.addObject("catelist", model);
		return mav;
	}

	@RequestMapping(value = "/add-cart/{id}", method = RequestMethod.GET)
	public String addCart(HttpSession session, @PathVariable Long id, HttpServletRequest request) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = iCartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/edit-cart/{id}/{quantity}", method = RequestMethod.GET)
	public String editCart(HttpSession session, HttpServletRequest request, @PathVariable Long id,
			@PathVariable int quantity) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}

		cart = iCartService.EditCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/delete-cart/{id}", method = RequestMethod.GET)
	public String deleteCart(HttpSession session, @PathVariable Long id, HttpServletRequest request) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = iCartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalP", iCartService.TotalPrice(cart));
		session.setAttribute("TotalQ", iCartService.TotalQuantity(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/dat-hang", method = RequestMethod.GET)
	public ModelAndView checkout(HttpSession session, HttpServletRequest request, Authentication auth) {

		if (auth != null) {
			ModelAndView mav = new ModelAndView("client/checkout");
			OrderDTO model = new OrderDTO();
			MyUser user = SecurityUtils.getPrincipal();
			if (user != null) {
				model.setCustomer_id(user.getId());
				model.setShipping_email(user.getEmail());
				model.setShipping_name(user.getName());
			}
			mav.addObject("user", model);
			return mav;
		}
		ModelAndView mav = new ModelAndView("login");

		return mav;
	}
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkoutbill(HttpSession session, HttpServletRequest request, Authentication auth, @ModelAttribute("user") OrderDTO model) {

		if (auth != null) {
			Long id = iOrderService.AddOrder(model);
			if(id > 0)
			{
				HashMap<Long, CartDTO> carts = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
				iOrderService.AddOrderDetail(carts, id);
			}
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}

}
