package com.niniblog.service.impl;

import com.niniblog.bean.User;
import com.niniblog.bean.UserLoginBlack;
import com.niniblog.dao.UserDao;
import com.niniblog.dao.UserLoginBlackDao;
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

    @Autowired
    private UserLoginBlackDao userLoginBlackDao;

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

    /**
     * 添加到黑名单
     */
    public UserLoginBlack addUserLoginBlack(Integer userid,String ipaddress)
    {
        UserLoginBlack userLoginBlack= findUserLoginBlack(userid,ipaddress);
        if(userLoginBlack!=null)

    }

    /**
     * 查找登录黑名单
     */
    public UserLoginBlack findUserLoginBlack(Integer userid,String ipaddress)
    {
        UserLoginBlack loginBlack=new UserLoginBlack();
        loginBlack.setIpaddress(ipaddress);
        loginBlack.setUserid(userid);
        loginBlack=(UserLoginBlack)userLoginBlackDao.findByExampleOne(loginBlack);
        return loginBlack;
    }

    /**
     * 移除登录黑名单
     */
    public boolean removeUserLoginBlack(Integer userid,String ipaddress)
    {
        UserLoginBlack userLoginBlack= findUserLoginBlack(userid,ipaddress);
        if(userLoginBlack!=null)
        {
            userLoginBlackDao.delete(userLoginBlack.getId());
        }
        return true;
    }
}
