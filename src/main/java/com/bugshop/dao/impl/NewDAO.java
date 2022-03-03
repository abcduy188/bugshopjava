package com.bugshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugshop.dao.INewDAO;
import com.bugshop.mapper.NewMapper;
import com.bugshop.model.NewModel;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());
	}
}
