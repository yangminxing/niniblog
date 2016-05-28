package com.niniblog.dao.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.dao.BaseDao;
import com.niniblog.dao.BlogArticleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Yang on 2016/5/14.
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
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
}
