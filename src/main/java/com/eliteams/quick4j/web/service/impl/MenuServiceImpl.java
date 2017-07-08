package com.eliteams.quick4j.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.MenuMapper;
import com.eliteams.quick4j.web.model.Menu;
import com.eliteams.quick4j.web.service.MenuService;

@Service
public class MenuServiceImpl extends GenericServiceImpl<Menu, Integer> implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public GenericDao<Menu, Integer> getDao() {
		return menuMapper;
	}
	@Override
	public List<Menu> getMenusByRoleID(Integer roleId) {
		return menuMapper.selectMenusByRoleId(roleId);
	}



}
