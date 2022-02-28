package com.bugshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="homeControllerOfClient")
public class HomeController {
	 @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("client/home");
	      return mav;
	   }
	 
	 @RequestMapping(value="/dang-nhap", method = RequestMethod.GET)
	 public String Login() {
		 return "login";
	 }
	 
	 public String Register() {
		return "register";
	}
}
	
