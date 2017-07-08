package com.eliteams.quick4j.web.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.core.util.ApplicationUtils;
import com.eliteams.quick4j.web.dao.UserMapper;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.model.UserExample;
import com.eliteams.quick4j.web.service.UserService;

/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements
		UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public int insert(User model) {
		return userMapper.insertSelective(model);
	}

	@Override
	public int update(User model) {
		return userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User authentication(User user) {
		return userMapper.authentication(user);
	}

	@Override
	public User selectById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<User, Long> getDao() {
		return userMapper;
	}

	@Override
	public User selectByUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		final List<User> list = userMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public User register(User user) {
		// 设置注册用户信息
		user.setCreateTime(new Date());
		user.setState("1");
		user.setPassword(ApplicationUtils.sha256Hex(user.getPassword()));
		// 写入注册用户信息
		userMapper.insert(user);
		return user;
	}

	@Override
	public User authenticationForShiro(User user,HttpServletRequest request) {
		// 身份验证
		Subject subject = SecurityUtils.getSubject();
		//判断用户是否已登陆
		if(!subject.isAuthenticated()){
			try{
				subject.login(new UsernamePasswordToken(user.getUsername(), user
						.getPassword()));
			}catch(AuthenticationException e){
				//捕获到登陆操作异常时，返回空值
				return null;
			}
		}
		return user;
	}

}
