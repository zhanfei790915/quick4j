package com.eliteams.quick4j.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eliteams.quick4j.core.util.ApplicationUtils;
import com.eliteams.quick4j.web.model.User;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author StarZou
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 首页
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }
    
    /**
     * 锁屏
     * */
    @RequestMapping("/onlock")
    public String onLock(){
    	return "onlock";
    }
    
    /**
     * 解锁
     * */
    @RequestMapping("/unlock")
    public String unLock(@ModelAttribute("user") User user,Model model,HttpServletRequest request){
    	String pagePwd = ApplicationUtils.sha256Hex(user.getPassword());
    	User user2 = (User)request.getSession().getAttribute("userInfo");
    	String sessionPwd = user2.getPassword();
    	if(pagePwd.equals(sessionPwd)){
    		return "index";
    	}else{
    		return "redirect:/rest/user/logout";
    	}	
    }
}