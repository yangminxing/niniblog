package com.niniblog.dao.impl;

import com.niniblog.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2016/5/14.
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    private static Logger logger=Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> clazz;
    
    public BaseDaoImpl()
    {
        ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
        this.clazz=(Class)type.getActualTypeArguments()[0];
    }

    @Override
    public <T> void save(T obj) {
        getCurrentSession().save(obj);
    }

    @Override
    public T get(int id) {
        Class<T> tClass=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T article=(T)getCurrentSession().get(tClass,id);
        return article;
    }

    @Override
    public List<T> findByExample(T example)
    {
        ArrayList entities=new ArrayList();
        try
        {
            Criteria e=this.getCurrentSession().createCriteria(this.clazz);
            e.add(Example.create(example));
            entities.addAll(e.list());
        }
        catch (HibernateException ex)
        {
            throw ex;
        }
        return entities;
    }
}
