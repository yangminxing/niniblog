package com.niniblog.dao.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.dao.BaseDao;
import com.niniblog.dao.BlogArticleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yang on 2016/5/12.
 */
@Repository
public class BlogArticleDaoImpl extends BaseDaoImpl<BlogArticle> implements BaseDao<BlogArticle>{

}
