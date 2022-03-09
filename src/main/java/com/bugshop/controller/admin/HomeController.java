package com.bugshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;

@RestController(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private Cloudinary cloudinary;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	/*
	 * @RequestMapping(value = "/admin/upload", method = RequestMethod.GET) public
	 * String upload(Model model) { model.addAttribute("image", new upload());
	 * return "/admin/upload"; }
	 * 
	 * @PostMapping(value = "/admin/upload") public String add(@RequestBody upload
	 * upload) throws IOException { byte[] decodeBase64 =
	 * Base64.getDecoder().decode(upload.getFile().getBytes()); Map r =
	 * this.cloudinary.uploader().upload(upload.getFile().getBytes(),
	 * ObjectUtils.asMap("resource_type", "auto")); String image =(String)
	 * r.get("secure_url");
	 * 
	 * return "/"; }
	 */
}
