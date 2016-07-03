package com.niniblog.action;

import com.niniblog.bean.BlogArticle;
import com.niniblog.service.BlogArticleService;
import com.niniblog.util.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lenovo on 2016/5/13.
 */
@Controller
public class LinkController {

    @Autowired
    private BlogArticleService service;

    /**
     * 首页
     */
    @RequestMapping(value =  {"/index"})
    public ModelAndView list(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView=new ModelAndView("/index");
        List<BlogArticle> blogArticles=service.list(new BlogArticle(), 0 , 10);
        modelAndView.addObject("blogarticles",blogArticles);
        return modelAndView;
    }

}

