package com.niniblog.service.impl;

import com.niniblog.bean.BlogArticle;
import com.niniblog.service.BlogArticleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lenovo on 2016/5/13.
 */
@Service
@Transactional
public class  BlogArticleServiceImpl extends BaseServiceImpl<BlogArticle> implements BlogArticleService
{

}
