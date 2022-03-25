package com.bugshop.controller.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bugshop.dto.SlideDTO;
import com.bugshop.service.ISlidesService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Controller(value = "SlidesOfAdmin")
public class SlideController {
	@Autowired
	private ISlidesService iSlidesService;
	@Autowired
	private Cloudinary cloudinary;
	@RequestMapping(value = "/admin/slides", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("model") SlideDTO model, HttpSession session) {
		ModelAndView mav = new ModelAndView("/admin/slides/index");
		model.setListResult(iSlidesService.slides());
		mav.addObject("model", model);
		return mav;
	}
	@GetMapping(value = "/admin/slides/create")
	public ModelAndView create(@ModelAttribute("model") SlideDTO model) {
		ModelAndView mav = new ModelAndView("admin/slides/createSlide");
		return mav;
	}

	@PostMapping(value = "/admin/slides/create")
	public RedirectView createCate(@ModelAttribute("model") SlideDTO slidesDTO) throws IOException {

		byte[] image = slidesDTO.getImagefile().getBytes();
		if (image != null) { 
			Map r = this.cloudinary.uploader().upload(image,
					ObjectUtils.asMap("resource_type", "auto"));
			slidesDTO.setSlide_image((String) r.get("secure_url"));
		} else {

		}

		iSlidesService.save(slidesDTO);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/slides");
		return redirectView;
	}
	@GetMapping(value = "/admin/slides/edit")
	public ModelAndView editproduct(@RequestParam(value = "id", required = true) Long id) {
		ModelAndView mav = new ModelAndView("admin/slides/editSlide");
		SlideDTO model = new SlideDTO();
		if (id != null) {
			model = iSlidesService.findByID(id);
		}
		mav.addObject("model", model);
		return mav;
	}

	@PostMapping(value = "/admin/slides/edit")
	public RedirectView editproduct(@ModelAttribute("model") SlideDTO model) throws IOException {
		
		
		byte[] image = model.getImagefile().getBytes();
		RedirectView redirectView = new RedirectView();
		if (model.getImagefile().getSize()>0) { 
			Map r = this.cloudinary.uploader().upload(image,
					ObjectUtils.asMap("resource_type", "auto"));
			model.setSlide_image((String) r.get("secure_url"));
		}
		iSlidesService.save(model);

		
		redirectView.setUrl("/bugshop/admin/slides");
		return redirectView;
	}
	@GetMapping(value = "/admin/slides/delete")
	public RedirectView deleteCate(@RequestParam(value = "id", required = true) Long id) {

		iSlidesService.delete(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/slides");
		return redirectView;
	}
}
