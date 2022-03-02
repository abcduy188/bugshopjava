package com.bugshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ProductControllerofAdmin")
public class ProductController {
	 @RequestMapping(value = "/admin/product", method = RequestMethod.GET)
		public String index() {
			ModelAndView mav = new ModelAndView();
			return "/admin/product/index";
		}
	 
}
