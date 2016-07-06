package com.niniblog.service;

import com.niniblog.bean.BlogArticle;
import com.niniblog.result.DaoListResult;
/**
 * 博客文章实现类
 */
public interface BlogArticleService extends BaseService<BlogArticle>
{
    public DaoListResult<BlogArticle> list(BlogArticle blogArticle, int currentPageIndex, int currentPageSize);
}
