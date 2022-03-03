
package com.bugshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.model.NewModel;
import com.bugshop.service.INewService;

@Controller(value = "newsControllerOfAdmin")
public class NewsController {

	@Autowired
	private INewService service;

	@RequestMapping(value = "/admin/news/list", method = RequestMethod.GET)
	public String newsindex(@ModelAttribute("model") NewModel model) {
		ModelAndView mav = new ModelAndView();
		model.setListResult(service.findAll());
		mav.addObject("model", model);
		return "admin/new/index";
	}
}
