package com.bugshop.converter;

import org.springframework.stereotype.Component;

import com.bugshop.dto.SlideDTO;
import com.bugshop.entity.SlidesEntity;

@Component
public class SlideConverter {
	public SlideDTO toDto(SlidesEntity entity) {
		SlideDTO result = new SlideDTO();
		result.setiD(entity.getId());
		result.setStatus(entity.isStatus());
		result.setSlide_name(entity.getSlide_name());
		result.setSlide_image(entity.getSlide_image());
		result.setSlide_desc(entity.getSlide_desc());
		return result;
	}
	public SlidesEntity toEntity(SlideDTO entity) {
		SlidesEntity result = new SlidesEntity();
		result.setStatus(entity.isStatus());
		result.setSlide_name(entity.getSlide_name());
		result.setSlide_image(entity.getSlide_image());
		result.setSlide_desc(entity.getSlide_desc());
		return result;
	}
	public SlidesEntity toEntity(SlidesEntity result, SlideDTO dto) {
		result.setSlide_name(dto.getSlide_name());
		result.setSlide_image(dto.getSlide_image());
		result.setSlide_desc(dto.getSlide_desc());
		return result;
	}
}
