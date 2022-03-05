package com.bugshop.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.service.ICategoryService;

@Controller(value = "categoryCtrlOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;
	
	@GetMapping(value = "/admin/category")
	public ModelAndView index(@ModelAttribute("model") CategoryDTO model)
	{
		ModelAndView mav = new ModelAndView("admin/category/index");
		model.setListResult(iCategoryService.findAll());
		mav.addObject("cate", iCategoryService.findByID((long)1));
		mav.addObject("model",model);
		return mav;
	}
	@GetMapping(value = "/admin/category/create")
	public String createCate() {
		
		return "admin/category/createCategoryProduct";
	}
	@GetMapping(value = "/admin/category/edit")
	public ModelAndView editCate(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/category/editCategoryProduct");
		CategoryDTO model = new CategoryDTO();
		if (id != null) {
			model = iCategoryService.findByID(id);
		}
		mav.addObject("model", model);
		return mav;
	}
	
	
	
}
