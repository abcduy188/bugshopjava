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

import com.bugshop.dto.CategoryDTO;
import com.bugshop.dto.ProductDTO;
import com.bugshop.service.ICategoryService;
import com.bugshop.service.IProductService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Controller(value = "ProductControllerofAdmin")
public class ProductController {

	@Autowired
	private IProductService iProductService;
	@Autowired
	private ICategoryService iCategoryService;

	@Autowired
	private Cloudinary cloudinary;

	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("model") ProductDTO model, HttpSession session) {

		ModelAndView mav = new ModelAndView("/admin/product/index");
		model.setListResult(iProductService.list());
		mav.addObject("model", model);
		return mav;
	}

	@GetMapping(value = "/admin/product/create")
	public ModelAndView create(@ModelAttribute("model") ProductDTO productDTO) {
		ModelAndView mav = new ModelAndView("admin/product/createProduct");
		mav.addObject("categories", iCategoryService.findAllbypr());
		return mav;
	}

	@PostMapping(value = "/admin/product/create")
	public RedirectView createCate(@ModelAttribute("model") ProductDTO productDTO) throws IOException {

		byte[] image = productDTO.getImagefile().getBytes();
		if (image != null) { 
			Map r = this.cloudinary.uploader().upload(image,
					ObjectUtils.asMap("resource_type", "auto"));
			productDTO.setImage((String) r.get("secure_url"));
		} else {

		}

		int result = iProductService.save(productDTO);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/product");
		return redirectView;
	}
	
	@GetMapping(value = "/admin/product/edit")
	public ModelAndView editproduct(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/product/editProduct");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = iProductService.findByID(id);
		}
		mav.addObject("categories", iCategoryService.findAllbypr());
		mav.addObject("model", model);
		return mav;
	}

	@PostMapping(value = "/admin/product/edit")
	public RedirectView editproduct(@ModelAttribute("model") ProductDTO model) throws IOException {
		
		
		byte[] image = model.getImagefile().getBytes();
		RedirectView redirectView = new RedirectView();
		if (model.getImagefile().getSize()>0) { 
			Map r = this.cloudinary.uploader().upload(image,
					ObjectUtils.asMap("resource_type", "auto"));
			model.setImage((String) r.get("secure_url"));
		}
		iProductService.save(model);

		
		redirectView.setUrl("/bugshop/admin/product");
		return redirectView;
	}
	@GetMapping(value = "/admin/product/delete")
	public RedirectView deleteCate(@RequestParam(value = "id", required = false) Long id) {

		iProductService.delete(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/bugshop/admin/product");
		return redirectView;
	}

}
