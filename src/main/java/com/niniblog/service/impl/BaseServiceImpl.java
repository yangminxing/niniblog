package com.niniblog.service.impl;

import com.niniblog.dao.BaseDao;
import com.niniblog.result.DaoListResult;
import com.niniblog.service.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * ��������ʵ����
 */
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T>
{
    public Logger logger=Logger.getLogger("BaseServiceImpl");

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
    public DaoListResult<T> findByExample(T example) {
        return dao.findByExample(example);
    }

    @Override
    public DaoListResult<T> findByExample(T example,int index,int size)
    {
        return dao.findByExample(example,index,size);
    }
}
