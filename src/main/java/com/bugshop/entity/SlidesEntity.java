package com.bugshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
@Entity
@Table(name="slides")
public class SlidesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "slide_name",  columnDefinition = "nvarchar(255)")
	private String slide_name;
	
	
	@Column(name = "slide_image",columnDefinition = "ntext")
	private String slide_image;
	
	@Column(name = "slide_desc",  columnDefinition = "nvarchar(255)")
	private String slide_desc;

	
	@Column(name = "status",columnDefinition = "boolean default true")
	private boolean status;


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


	public Long getId() {
		return id;
	}

	
}


	