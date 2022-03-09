package com.bugshop.controller.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	 
	 @RequestMapping(value="/thoat", method = RequestMethod.GET)
	 public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response) {
		 
			Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // = isAutheticated o header.jsp
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth); // logout = sessionUtils
			}
		 return new ModelAndView("redirect:/trang-chu");
	 }
	 @GetMapping(value = "/accessDenied")
		public ModelAndView accessDenied() {
			return new ModelAndView("redirect:/dang-nhap?accessDenied");
		}
}
	
