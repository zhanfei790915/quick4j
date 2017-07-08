package com.eliteams.quick4j.web.service;

import javax.servlet.http.HttpServletRequest;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.User;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService extends GenericService<User, Long> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);
    
    /**
     * 用户验证(shiro)
     * @param user
     * @return
     * */
    User authenticationForShiro(User user,HttpServletRequest request);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
    
    /**
     * 新增注册用户
     * @param user
     * @return user
     * */
    User register(User user);
}
