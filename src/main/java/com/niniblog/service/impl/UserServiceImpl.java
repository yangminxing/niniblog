package com.niniblog.service.impl;

import com.niniblog.bean.User;
import com.niniblog.dao.UserDao;
import com.niniblog.service.UserService;
import com.niniblog.util.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * 注册用户实现类
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 验证用户是否已经登录
     */
    public boolean login(String username,String password,HttpSession session)
    {



    }
}
