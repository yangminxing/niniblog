package com.niniblog.dao.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.dao.BaseDao;
import com.niniblog.result.DaoListResult;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
@Primary
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    private static Logger logger = Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> clazz;

    //危险的类型转换进行了忽略
    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type)
                    .getActualTypeArguments();
            clazz = (Class<T>) parameterizedType[0];
        }
    }

    public <T> void save(T obj) {
        getCurrentSession().save(obj);
    }

    public <T> void update(T obj) {
        getCurrentSession().update(obj);
    }

    public <T> void saveOrUpdate(T obj) {
        getCurrentSession().saveOrUpdate(obj);
    }

    public void delete(int id) {
        Session session = this.getCurrentSession();
        Object entity = session.get(this.clazz, id);
        session.delete(entity);
    }

    public T get(int id) {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T article = (T) getCurrentSession().get(tClass, id);
        return article;
    }

    public DaoListResult<T> findByExample(T example) {
        ArrayList entities = new ArrayList();
        int rowCount;
        try {
            Criteria e = this.getCurrentSession().createCriteria(this.clazz);
            e.add(Example.create(example));
            //添加业务List
            entities.addAll(e.list());
            //读取行数
            rowCount = Integer.valueOf(e.
                    setProjection(Projections.rowCount()).
                    uniqueResult().toString());
        } catch (HibernateException ex) {
            throw ex;
        }
        return new DaoListResult<T>(entities, rowCount);
    }

    public T findByExampleOne(T example) {
        ArrayList entities = new ArrayList();
        try {
            Criteria e = this.getCurrentSession().createCriteria(this.clazz);
            e.add(Example.create(example));
            entities.addAll(e.list());
        } catch (HibernateException ex) {
            throw ex;
        }

        if (entities.size() > 0)
            return (T) entities.get(0);

        return null;
    }

    public DaoListResult<T> findByExample(T example, int pageIndex, int pageSize) {
        ArrayList<T> entities = new ArrayList<T>();
        int rowCount;
        try {
            Criteria e = this.getCurrentSession().createCriteria(this.clazz);

            e.add(Example.create(example));

            e.setProjection(null);

            e.setFirstResult(0);
            e.setMaxResults(pageSize);
            //添加业务List
            entities.addAll(e.list());
            //读取行数
            rowCount = Integer.valueOf(e.
                    setProjection(Projections.rowCount()).
                    uniqueResult().toString());
        } catch (HibernateException ex) {
            throw ex;
        }
        return new DaoListResult<T>(entities, rowCount);

    }
}
