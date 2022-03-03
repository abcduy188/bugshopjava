package com.bugshop.dao;

import java.util.List;

import com.bugshop.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	
	List<NewModel> findAll();
	
}
