package com.niniblog.action;

import com.niniblog.bean.BlogArticle;
import com.niniblog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yang on 2016/5/12.
 */
@Controller
public class BlogArticleController {

    @Autowired
    private BlogArticleService service;

    @RequestMapping(value="/blogarticle/add")
    public ModelAndView add()
    {
        ModelAndView modelAndView=new ModelAndView("blogarticle/add_blogarticle");
        modelAndView.addObject("blogArticle",new BlogArticle());
        return modelAndView;
    }

    @RequestMapping(value="/blogarticle/save")
    public ModelAndView save(@ModelAttribute BlogArticle blogArticle)
    {
        ModelAndView mav=new ModelAndView("home");
        service.save(blogArticle);

        String message="save successfully";
        mav.addObject("message",message);
        return mav;
    }

    @RequestMapping(value="/blogarticle/load/{id}",method= RequestMethod.GET)
    public ModelAndView load(@PathVariable Integer id)
    {
        ModelAndView mav=new ModelAndView("/blogarticle/load_blogarticle");
        BlogArticle blogArticle=service.get(id);
        mav.addObject("blogarticle",blogArticle);
        return mav;
    }


    public void transfer()
    {

    }
}
