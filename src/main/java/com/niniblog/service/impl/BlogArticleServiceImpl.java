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
 * 博客文章实现类
 */
@Service
@Transactional
public class  BlogArticleServiceImpl extends BaseServiceImpl<BlogArticle> implements BlogArticleService
{
    @Autowired
    private BlogArticleDao blogArticleDao;

    /**
     * 显示文章
     */
    public List<BlogArticle> list(BlogArticle blogArticle,HttpContext context)
    {
        return blogArticleDao.findByExample(blogArticle,context.getCurrentPageIndex(),context.getPageSize());
    }
}
