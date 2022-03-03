package com.bugshop.service;

import java.util.List;

import com.bugshop.model.NewModel;
import com.bugshop.paging.Pageble;

public interface INewService {
	List<NewModel> findAll();
}
