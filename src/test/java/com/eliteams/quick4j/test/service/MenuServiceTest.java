package com.eliteams.quick4j.test.service;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.Menu;
import com.eliteams.quick4j.web.model.Role;
import com.eliteams.quick4j.web.service.MenuService;

public class MenuServiceTest extends TestSupport{
	@Resource
	private MenuService menuService;
	
	@Test
	public void testGetMenusByRoleID() {
		start();
		Role role = new Role();
		role.setId(2l);
		List<Menu> menuList = menuService.getMenusByRoleID(role.getId().intValue());
		for(Menu menu : menuList){
			this.logger.info("menu id:"+menu.getId());
			this.logger.info("menu name:"+menu.getMname());
			this.logger.info("menu murl:"+menu.getMurl());
		}
		end();
		
	}

	@Test
	public void testInsert() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		//fail("Not yet implemented");
	}

}
