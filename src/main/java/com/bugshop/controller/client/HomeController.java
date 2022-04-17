package com.bugshop.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugshop.dto.CategoryDTO;
import com.bugshop.dto.ProductDTO;
import com.bugshop.dto.SlideDTO;
import com.bugshop.dto.UserDTO;
import com.bugshop.entity.ProductEntity;
import com.bugshop.service.ICategoryService;
import com.bugshop.service.IProductService;
import com.bugshop.service.ISlidesService;
import com.bugshop.service.IUserService;

@Controller(value = "homeControllerOfClient")
public class HomeController {

	@Autowired
	private IUserService userService;
	@Autowired
	private ICategoryService iCategoryService;
	@Autowired
	private IProductService iProductService;
	@Autowired
	private ISlidesService iSlidesService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		CategoryDTO model = new CategoryDTO();
		ProductDTO products = new ProductDTO();
		SlideDTO slide = new SlideDTO();
		slide.setListResult(iSlidesService.slideshome());
		model.setListResult(iCategoryService.listactive());
		products.setListResult(iProductService.productsHighlights());
		ModelAndView mav = new ModelAndView("client/home");
		mav.addObject("catelist", model);
		mav.addObject("highlights", products);
		mav.addObject("slides", slide);
		return mav;
	}

	@GetMapping(value = "/danh-muc")
	public ModelAndView category(@RequestParam(value = "id", required = true) Long id) {
		CategoryDTO model = new CategoryDTO();
		ProductDTO prodto = new ProductDTO();
		model.setListResult(iCategoryService.listactive());
		prodto.setListResult(iProductService.productbycate(id));
		ModelAndView mav = new ModelAndView("client/category");
		mav.addObject("catelist", model);
		mav.addObject("productlist", prodto);
		return mav;
	}

	@GetMapping(value = "/san-pham")
	public String allCate(@RequestParam(value = "page", required = false) int pageNumber, Model model) {
		Page<ProductEntity> page = iProductService.listEntity(pageNumber);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages(); //3
		CategoryDTO cate = new CategoryDTO();
		cate.setListResult(iCategoryService.listactive());
		List<ProductEntity> listProducts = page.getContent();
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("model", listProducts);
		model.addAttribute("catelist", cate);
		return "client/allproduct";
	}

	@GetMapping(value = "/san-pham/{seotitle}")
	public ModelAndView product(@RequestParam(value = "id", required = true) Long id) {
		CategoryDTO model = new CategoryDTO();
		ProductDTO prodto = new ProductDTO();
		model.setListResult(iCategoryService.listactive());
		prodto = iProductService.findByID(id);
		prodto.setListResult(iProductService.productbycate(prodto.getCategoryId()));
		ModelAndView mav = new ModelAndView("client/product");
		mav.addObject("catelist", model);
		mav.addObject("productlist", prodto);
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String Login() {
		return "login";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public String Register(@ModelAttribute("register") UserDTO model) {
		return "register";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView RegisterUser(@ModelAttribute("register") UserDTO model) {

		int i = userService.register(model);
		if (i == 1) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Dang Ky thanh cong!!");
			return mav;
		}
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("message", "Email da co nguoi su dung");
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
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
	@GetMapping(value = "/tim-kiem")
	@ResponseBody
	public ModelAndView search(@RequestParam(value = "name") String pSearchTerm) {
		CategoryDTO model = new CategoryDTO();
		ProductDTO prodto = new ProductDTO();
		model.setListResult(iCategoryService.listactive());
		prodto.setListResult(iProductService.search(pSearchTerm));
		ModelAndView mav = new ModelAndView("client/search");
		mav.addObject("catelist", model);
		mav.addObject("productlist", prodto);
		return mav;
	}
	
}
