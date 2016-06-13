package com.niniblog.action;

import com.niniblog.bean.BlogArticle;
import com.niniblog.service.BlogArticleService;
import com.niniblog.util.HttpContext;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 博客类文章控制器
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

    /**
     * 根据Author显示Author的
     */
    @RequestMapping(value =  "/{author}")
    public ModelAndView list(@ModelAttribute("author") String author, HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView=new ModelAndView("/blogarticle/list_blogarticle");
        List<BlogArticle> blogArticles=service.list(new BlogArticle(), new HttpContext(request, response));
        modelAndView.addObject("blogarticles",blogArticles);
        return modelAndView;
    }

    public void transfer()
    {

    }
}
