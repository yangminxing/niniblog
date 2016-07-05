package com.niniblog.service.impl;

import com.niniblog.bean.User;
import com.niniblog.bean.UserLoginBlack;
import com.niniblog.dao.UserDao;
import com.niniblog.dao.UserLoginBlackDao;
import com.niniblog.result.DaoListResult;
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
        DaoListResult<User> daolist=userDao.findByExample(user);
        if(daolist==null||daolist.getDaoList().size()==0)
            return null;

        return daolist.getDaoList().get(0);
    }

    /**
     * 添加到黑名单
     */
    public void addUserLoginBlack(Integer userid,String ipaddress)
    {
        UserLoginBlack userLoginBlack= findUserLoginBlack(userid,ipaddress);
        //如果之前没有黑名单 插入操作
        if(userLoginBlack!=null)
        {
            userLoginBlack.setLimited(1);
            userLoginBlack.setUserid(userid);
            userLoginBlack.setIpaddress(ipaddress);
            userLoginBlackDao.save(userLoginBlack);
        }
        //如果之前更新加1
        else
        {
            userLoginBlack.setLimited(userLoginBlack.getLimited()+1);
            userLoginBlackDao.saveOrUpdate(userLoginBlack);
        }

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
