package com.eliteams.quick4j.test.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.eliteams.quick4j.core.util.ApplicationUtils;
import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.service.UserService;

public class UserServiceTest extends TestSupport {

    @Resource
    private UserService userService;

    @Test
    public void test_insert() {
        User model = new User();
        model.setUsername("zhan333");
        model.setPassword(ApplicationUtils.sha256Hex("111111"));
        model.setCreateTime(new Date());
        userService.insert(model);
    }

    @Test
    public void test_10insert() {
        for (int i = 0; i < 10; i++) {
            User model = new User();
            model.setUsername("starzou111" + i);
            model.setPassword(ApplicationUtils.sha256Hex("123456"));
            model.setCreateTime(new Date());
            userService.insert(model);
        }
    }

}
