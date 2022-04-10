package com.bugshop.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.dto.UserDTO;
import com.bugshop.entity.OrderDetailEntity;
import com.bugshop.entity.OrderEntity;
import com.bugshop.entity.UserEntity;
import com.bugshop.service.ICategoryService;
import com.bugshop.service.IOrderService;
import com.bugshop.service.IUserService;

@Controller(value = "userControllerOfClient")
public class UserController {

	@Autowired
	IUserService iuserService;
	@Autowired
	ICategoryService iCategoryService;
	@Autowired
	IUserService userService;
	@Autowired
	IOrderService iOrderService;
	
	@GetMapping(value = "thong-tin")
	public String editproduct(@RequestParam(value = "id", required = false) Long id, Model model) {
		ModelAndView mav = new ModelAndView("client/user/index");
		UserDTO user = new UserDTO();
		List<OrderEntity> listOrders = iOrderService.findByUser(id);
		CategoryDTO ListCate = new CategoryDTO();
		ListCate.setListResult(iCategoryService.listactive());
		if (id != null) {
			user = iuserService.user(id);
		}
		model.addAttribute("model",user);
		model.addAttribute("catelist",ListCate);
		model.addAttribute("listOrders",listOrders);
		return "client/user/index";
	}
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String RegisterUser(@ModelAttribute("model") UserDTO userdto, HttpServletRequest request) {
		int i = userService.save(userdto);
		return "redirect:" + request.getHeader("Referer");
	}
	@GetMapping(value = "/details-order/{id}")
	public String orderdetails(@PathVariable(value = "id", required = true) Long id, Model model) {
		OrderEntity order = iOrderService.findOne(id);
		List<OrderDetailEntity> listDetails = iOrderService.findByOrder(id);
		CategoryDTO ListCate = new CategoryDTO();
		ListCate.setListResult(iCategoryService.listactive());
		
		model.addAttribute("catelist",ListCate);
		model.addAttribute("order",order);
		model.addAttribute("listDetails",listDetails);
		return "client/user/orderdetails";
	}
	@GetMapping(value = "/orders/cancel")
	public String unactiveS(@RequestParam(value = "id", required = true) Long id, HttpServletRequest request) {
		iOrderService.cancel(id);
		return "redirect:" + request.getHeader("Referer");
	}
}
