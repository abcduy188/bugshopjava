package com.bugshop.dao;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class upload {
	@Transient
	private MultipartFile file;
	private String fileName;
	private String base64;
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
