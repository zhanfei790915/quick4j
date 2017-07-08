package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Menu;
import com.eliteams.quick4j.web.model.MenuExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends GenericDao<Menu, Integer>{
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    @Override
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    @Override
    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    @Override
    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    @Override
    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**
     * 根据用户ID查询该用户ID对应的菜单集合
     * @param  角色ID
     * @return 该角色所对应的菜单集合
     * */
    List<Menu>  selectMenusByRoleId(Integer roleId);
}