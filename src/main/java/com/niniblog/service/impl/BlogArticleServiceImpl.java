package com.niniblog.service.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.util.HttpContext;
import com.niniblog.dao.BlogArticleDao;
import com.niniblog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * ��������ʵ����
 */
@Service
@Transactional
public class  BlogArticleServiceImpl extends BaseServiceImpl<BlogArticle> implements BlogArticleService
{
    @Autowired
    private BlogArticleDao blogArticleDao;

    /**
     * ��ʾ��ǰ��¼
     */
    public List<BlogArticle> listMaster(BlogArticle blogArticle,HttpContext context)
    {
        int userid=user.getId();


    }
}
