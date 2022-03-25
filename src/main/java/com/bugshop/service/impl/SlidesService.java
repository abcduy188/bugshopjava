package com.bugshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.converter.SlideConverter;
import com.bugshop.dto.SlideDTO;
import com.bugshop.entity.SlidesEntity;
import com.bugshop.repository.SlidesRepository;
import com.bugshop.service.ISlidesService;

@Service
public class SlidesService implements ISlidesService{

	@Autowired
	SlidesRepository slidesRepository;
	@Autowired
	SlideConverter slideConverter;
	@Override
	public List<SlideDTO> slides() {
		List<SlidesEntity> entities = slidesRepository.findAll();

		List<SlideDTO> models = new ArrayList<>();
		for (SlidesEntity item : entities) {
			SlideDTO slideDTO = slideConverter.toDto(item);
			models.add(slideDTO);
		}
		return models;
	}

	@Override
	public SlideDTO findByID(Long id) {
		SlideDTO dto = slideConverter.toDto(slidesRepository.findOne(id));
		return dto;
	}

	@Override
	public void save(SlideDTO slideDTO) {
		SlidesEntity sliEntity = new SlidesEntity();
		
		if(slideDTO.getiD()!= null) {
			SlidesEntity oldCate= slidesRepository.findOne(slideDTO.getiD());
			sliEntity = slideConverter.toEntity(oldCate, slideDTO);
		}
		else {
			sliEntity = slideConverter.toEntity(slideDTO);
		}
		
		slideConverter.toDto(slidesRepository.save(sliEntity));
		
	}
	@Override
	public void delete(Long id) {
		SlidesEntity oldCate= slidesRepository.findOne(id);
		if(id!= null) {
			oldCate.setStatus(false);
		}
		slideConverter.toDto(slidesRepository.save(oldCate));
	}

	@Override
	public List<SlideDTO> slideshome() {
		List<SlidesEntity> entities = slidesRepository.slideHome();

		List<SlideDTO> models = new ArrayList<>();
		for (SlidesEntity item : entities) {
			SlideDTO slideDTO = slideConverter.toDto(item);
			models.add(slideDTO);
		}
		return models;
	}

}
