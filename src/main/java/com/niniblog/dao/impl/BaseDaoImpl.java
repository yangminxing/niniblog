package com.niniblog.dao.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.Transient;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 底层的Dao实现
 */
@SuppressWarnings("unchecked")
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    private static Logger logger=Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transient  private Class<T> clazz;

    //危险的类型转换进行了忽略
    @SuppressWarnings("unchecked")
    public BaseDaoImpl()
    {
        Class obtainedClass=getClass();
        Type genericSuperclass=null;
        for(;;)
        {
            if(obtainedClass.getGenericSuperclass().equals(Object.class))
                break;
            genericSuperclass=obtainedClass.getGenericSuperclass();
            if(genericSuperclass instanceof ParameterizedType)
                break;
            obtainedClass=obtainedClass.getSuperclass();
        }

        if(genericSuperclass!=null) {
            ParameterizedType gen = (ParameterizedType) genericSuperclass;
            clazz = ((Class) (Class) gen.getActualTypeArguments()[0]);
        }
    }

    @Override
    public <T> void save(T obj) {
        getCurrentSession().save(obj);
    }

    @Override
    public <T> void update(T obj)
    {
        getCurrentSession().update(obj);
    }

    @Override
    public <T> void saveOrUpdate(T obj)
    {
        getCurrentSession().saveOrUpdate(obj);
    }

    @Override
    public void delete(int id)
    {
        Session session=this.getCurrentSession();
        Object entity=session.get(this.clazz,id);
        session.delete(entity);
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

    @Override
    public T findByExampleOne(T example)
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

        if(entities.size()>0)
            return (T)entities.get(0);

        return null;
    }

    @Override
    public List<T> findByExample(T example,int pageIndex,int pageSize)
    {
        ArrayList<T> entities=new ArrayList<T>();
        try
        {
            Criteria e=this.getCurrentSession().createCriteria(this.clazz);
            e.add(Example.create(example)).setFirstResult(pageIndex).setMaxResults(pageSize);
            entities.addAll(e.list());
        }
        catch(HibernateException ex)
        {
            throw ex;
        }
        return entities;
    }
}
