package com.niniblog.service.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.dao.BaseDao;
import com.niniblog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lenovo on 2016/5/15.
 */
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T>
{
    @Autowired
    private BaseDao<T> dao;

    @Override
    public void save(T t)
    {
        dao.save(t);
    }

    @Override
    public T get(int id)
    {
        return dao.get(id);
    }
}
