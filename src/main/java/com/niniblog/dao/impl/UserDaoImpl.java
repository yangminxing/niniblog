package com.niniblog.dao.impl;

import com.niniblog.bean.User;
import com.niniblog.dao.BaseDao;
import com.niniblog.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * �û�ʵ��Dao��
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {
}
