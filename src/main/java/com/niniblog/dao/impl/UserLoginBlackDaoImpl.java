package com.niniblog.dao.impl;

import com.niniblog.bean.UserLoginBlack;
import com.niniblog.dao.UserLoginBlackDao;
import org.springframework.stereotype.Repository;

/**
 * 登录黑名单Dao层
 */
@Repository
public class UserLoginBlackDaoImpl extends BaseDaoImpl<UserLoginBlack> implements UserLoginBlackDao<UserLoginBlack>
{
}
