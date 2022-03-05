package com.bugshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.service.ICategoryService;

@RestController(value = "categoryCtrlOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	@GetMapping(value = "admin/category")
	public ModelAndView index(@ModelAttribute("model") CategoryDTO model) {
		ModelAndView mav = new ModelAndView("admin/category/index");
		model.setListResult(iCategoryService.findAll());
		mav.addObject("cate", iCategoryService.findByID((long) 1));
		mav.addObject("model", model);
		return mav;
	}

	@GetMapping(value = "/admin/category/create")
	public ModelAndView create(@ModelAttribute("model") CategoryDTO categoryDTO) {
		ModelAndView mav = new ModelAndView("admin/category/createCategoryProduct");
		return mav;
	}

	@PostMapping(value = "/admin/category/create")
	public String createCate(@ModelAttribute("model") CategoryDTO categoryDTO) {

		iCategoryService.save(categoryDTO);
		return "admin/category";
	}

	@GetMapping(value = "/admin/category/edit")
	public ModelAndView editCate(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/category/editCategoryProduct");
		CategoryDTO model = new CategoryDTO();
		if (id != null) {
			model = iCategoryService.findByID(id);
		}
		mav.addObject("model", model);
		return mav;
	}

	@PostMapping(value = "/admin/category/edit")
	public RedirectView editCate(@ModelAttribute("model") CategoryDTO model) {

		iCategoryService.save(model);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/category");
		return redirectView;
	}

	@GetMapping(value = "/admin/category/delete")
	public RedirectView deleteCate(@RequestParam(value = "id", required = false) Long id) {

		iCategoryService.delete(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/category");
		return redirectView;
	}

}
