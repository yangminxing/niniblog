package com.niniblog.dao.impl;

import com.niniblog.bean.User;
import com.niniblog.dao.BaseDao;
import com.niniblog.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 用户实现Dao层
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {
}
