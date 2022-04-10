package com.bugshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.ProductDTO;
import com.bugshop.dto.UserDTO;
import com.bugshop.entity.UserEntity;
import com.bugshop.service.ICategoryService;
import com.bugshop.service.IUserService;

@RestController(value = "userCtrlOfAdmin")
public class UserController {

	@Autowired
	IUserService iuserService;
	
	@GetMapping(value = "admin/user")
	public ModelAndView index(@ModelAttribute("model") UserDTO model) {
		ModelAndView mav = new ModelAndView("admin/user/index");
		model.setListResult(iuserService.findAll());
		mav.addObject("categories", iuserService.findAll());
		mav.addObject("model", model);
		return mav;
	}

}
