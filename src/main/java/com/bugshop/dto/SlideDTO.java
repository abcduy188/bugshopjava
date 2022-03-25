package com.bugshop.dto;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class SlideDTO extends AbstractDTO<SlideDTO> {

	private String slide_name;

	private String slide_image;

	private String slide_desc;

	private boolean status;

	@Transient
	private MultipartFile imagefile;
	
	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	public String getSlide_name() {
		return slide_name;
	}

	public void setSlide_name(String slide_name) {
		this.slide_name = slide_name;
	}

	public String getSlide_image() {
		return slide_image;
	}

	public void setSlide_image(String slide_image) {
		this.slide_image = slide_image;
	}

	public String getSlide_desc() {
		return slide_desc;
	}

	public void setSlide_desc(String slide_desc) {
		this.slide_desc = slide_desc;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
