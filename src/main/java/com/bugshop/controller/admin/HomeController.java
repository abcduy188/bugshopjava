package com.bugshop.controller.admin;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bugshop.dao.upload;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private Cloudinary cloudinary;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	@RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
	public String upload(Model model) {
		model.addAttribute("image", new upload());
		return "/admin/upload";
	}
	@PostMapping(value = "/admin/upload")
	public String add(@ModelAttribute(value = "file") upload upload) throws IOException {
		Map r = this.cloudinary.uploader().upload(upload.getFile().getBytes(), 
					ObjectUtils.asMap("resource_type", "auto"));
		
		String image =(String) r.get("secure_url");
	
		return "/";
	}
}
