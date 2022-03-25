package com.bugshop.service;

import java.util.List;

import com.bugshop.dto.SlideDTO;

public interface ISlidesService {
	List<SlideDTO> slides();
	List<SlideDTO> slideshome();
	SlideDTO findByID(Long id);
	void save(SlideDTO slideDTO);
	void delete(Long id);
}
