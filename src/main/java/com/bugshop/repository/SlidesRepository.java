package com.bugshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bugshop.entity.SlidesEntity;

public interface SlidesRepository  extends JpaRepository<SlidesEntity, Long>{
	@Query(value="SELECT * FROM slides WHERE status = true", nativeQuery = true)
	List<SlidesEntity> slideHome();
}
