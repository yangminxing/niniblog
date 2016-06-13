package com.niniblog.service;

import com.niniblog.bean.BlogArticle;
import com.niniblog.util.HttpContext;

import java.util.List;

/**
 * 博客文章实现类
 */
public interface BlogArticleService extends BaseService<BlogArticle>
{
    public List<BlogArticle> list(BlogArticle blogArticle,HttpContext context);
}
