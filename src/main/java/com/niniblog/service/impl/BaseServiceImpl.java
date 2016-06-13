package com.niniblog.service.impl;

import com.niniblog.dao.BaseDao;
import com.niniblog.service.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 基本服务实现类
 */
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T>
{
    public Logger logger=Logger.getLogger("BaseServiceImpl");

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

    @Override
    public List<T> findByExample(T example) {
        return dao.findByExample(example);
    }

    @Override
    public List<T> findByExample(T example,int index,int size)
    {
        return dao.findByExample(example,index,size);
    }
}
