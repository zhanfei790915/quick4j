package com.eliteams.quick4j.web.service;

import java.util.List;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Menu;

public interface MenuService extends GenericService<Menu, Integer> {

	/**
	 * 根据角色ID得到该 角色拥有的菜单集合
	 * */
	List<Menu> getMenusByRoleID(Integer roleId);
}
