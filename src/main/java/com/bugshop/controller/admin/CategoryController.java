package com.bugshop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.model.NewModel;
import com.bugshop.service.ICategoryService;

@Controller(value = "categoryCtrlOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;
	
	@GetMapping(value = "/admin/category")
	public ModelAndView index(@ModelAttribute("model") CategoryDTO model)
	{
		ModelAndView mav = new ModelAndView("admin/category/index");
		List<CategoryDTO> list = new ArrayList<>();
		list = iCategoryService.findAll();
		model.setListResult(list);
		List<CategoryDTO> list1 = new ArrayList<>();
		list1 = model.getListResult();
		mav.addObject("model",model);
		return mav;
	}
	
	
}
