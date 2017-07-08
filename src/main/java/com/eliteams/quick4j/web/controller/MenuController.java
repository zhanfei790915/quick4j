package com.eliteams.quick4j.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eliteams.quick4j.web.model.Menu;
import com.eliteams.quick4j.web.model.Role;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.service.MenuService;
import com.eliteams.quick4j.web.service.RoleService;
import com.eliteams.quick4j.web.service.UserService;

/**
 * @author zhanfei
 * @since 2017年7月2日 下午4:59:34
 * */
@Controller
@RequestMapping("menu")
public class MenuController {
	@Resource
	private MenuService menuService;
	@Resource
	private RoleService roleService;
	@Resource
	private UserService userService;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 首页显示菜单
	 * 
	 * @param user
	 * @return menuListJson
	 * */
	@RequestMapping(value = "/getMenu", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menu(@ModelAttribute("username") String username,Model model,HttpServletRequest request) {
		User user2 = userService.selectByUsername(username.trim());
		List<Role> roles = roleService.selectRolesByUserId(user2.getId());
		List<Menu> menus = new ArrayList<Menu>();
		for (Role role : roles) {
			menus.addAll(menuService.getMenusByRoleID(role.getId().intValue()));
		}
		Comparator<Menu> comparator = new Comparator<Menu>(){  
			   public int compare(Menu m1, Menu m2) {  
				    //只对pid排序
				    if(m1.getPid()!=m2.getPid()){
				    	return m1.getPid() - m2.getPid();
				    }else{  
				        //pid相同则按id排序  
				        if(m1.getId() != m2.getId()){  
				        	return m1.getId() - m2.getId(); 
				        } 
				    }  
				    return 0;
			   }  
		};
		Collections.sort(menus,comparator);
		String result = "";
		try {
			result = objectMapper.writeValueAsString(menus);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
