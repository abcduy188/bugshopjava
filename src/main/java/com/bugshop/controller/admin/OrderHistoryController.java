package com.bugshop.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.entity.OrderDetailEntity;
import com.bugshop.entity.OrderEntity;
import com.bugshop.service.IOrderService;
import com.bugshop.service.IUserService;

@Controller(value = "orderCtrlOfAdmin")
public class OrderHistoryController {

	@Autowired
	IUserService iuserService;
	@Autowired
	IOrderService iOrderService;
	
	@GetMapping(value = "admin/orders")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("admin/orders/index");
		mav.addObject("listOrder", iOrderService.findAll());
		return mav;
	}
	@GetMapping(value = "admin/details-order/{id}")
	public ModelAndView orderdetails(@PathVariable(value = "id", required = true) Long id) {
		ModelAndView mav = new ModelAndView("admin/orders/detailOrder");
		OrderEntity order = iOrderService.findOne(id);
		List<OrderDetailEntity> listDetails = iOrderService.findByOrder(id);
		mav.addObject("order",order);
		mav.addObject("listDetails",listDetails);
		return mav;
	}
	@GetMapping(value = "admin/orders/accept")
	public String activeS(@RequestParam(value = "id", required = true) Long id) {
		iOrderService.accept(id);
		return "redirect:/admin/orders";
	}
	@GetMapping(value = "admin/orders/cancel")
	public String unactiveS(@RequestParam(value = "id", required = true) Long id) {
		iOrderService.cancel(id);
		return "redirect:/admin/orders";
	}
}
