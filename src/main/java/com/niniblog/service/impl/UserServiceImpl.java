package com.niniblog.service.impl;

import com.niniblog.bean.User;
import com.niniblog.dao.UserDao;
import com.niniblog.service.UserService;
import com.niniblog.util.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 注册用户实现类
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 查找用户
     */
    public User find(User user)
    {
        List<User> list=userDao.findByExample(user);
        if(list==null||list.size()==0)
            return null;

        return list.get(0);
    }
}
