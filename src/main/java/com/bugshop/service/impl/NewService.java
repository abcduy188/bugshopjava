package com.bugshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugshop.dao.ICategoryDAO;
import com.bugshop.dao.INewDAO;
import com.bugshop.model.NewModel;
import com.bugshop.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private INewDAO newDao;

	


	@Override
	public List<NewModel> findAll() {
		return newDao.findAll();
	}


}
