package com.niniblog.action;

import com.niniblog.bean.BlogArticle;
import com.niniblog.service.BlogArticleService;
import com.niniblog.util.HttpContext;
import com.niniblog.validator.PageParameterValidtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        ModelAndView mav=new ModelAndView("/blogarticle/edit_blogarticle");
        BlogArticle blogArticle=new BlogArticle();
        blogArticle.setTitle("cao");
        mav.addObject("blogarticle",blogArticle);
        return mav;
    }

    /**
     * 首页 列表
     */
    @RequestMapping(value = "/blogarticle/list")
    public ModelAndView list(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView=new ModelAndView("/blogarticle/list_blogarticle");

        int currentPageIndex = HttpContext.getCurrentPageIndex(request);
        int currentPageSize = HttpContext.getPageSize(request);
        if(currentPageIndex == -1||currentPageSize == -1)
        {
            return modelAndView;
        }
        List<BlogArticle> blogArticles=service.list(new BlogArticle(), currentPageIndex , currentPageSize);
        modelAndView.addObject("blogarticles",blogArticles);
        return modelAndView;
    }

//    /**
//     * 根据Author显示Author的
//     */
//    @RequestMapping(value =  "/{author}")
//    public ModelAndView list(@ModelAttribute("author") String author, HttpServletRequest request,HttpServletResponse response)
//    {
//        ModelAndView modelAndView=new ModelAndView("/blogarticle/list_blogarticle");
//        List<BlogArticle> blogArticles=service.list(new BlogArticle(), new HttpContext(request, response));
//        modelAndView.addObject("blogarticles",blogArticles);
//        return modelAndView;
//    }

    public void transfer()
    {

    }
}
