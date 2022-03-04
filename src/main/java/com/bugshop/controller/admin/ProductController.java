package com.bugshop.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.dto.ProductDTO;
import com.bugshop.service.IProductService;

@Controller(value = "ProductControllerofAdmin")
public class ProductController {
	
	@Autowired
	private IProductService iProductService;
	 @RequestMapping(value = "/admin/product", method = RequestMethod.GET)
		public ModelAndView index(@ModelAttribute("model") ProductDTO model,HttpSession session) {
		 
			ModelAndView mav = new ModelAndView("/admin/product/index");
			model.setListResult(iProductService.list());
			mav.addObject("model", model);
			return mav;
		}
	 
}
