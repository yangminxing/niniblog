package com.niniblog.action;

import com.google.gson.Gson;
import com.niniblog.bean.BlogArticle;
import com.niniblog.result.DaoListResult;
import com.niniblog.result.FrontEndListResult;
import com.niniblog.service.BlogArticleService;
import com.niniblog.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 博客类文章控制器
 */
@Controller
public class BlogArticleController {

    @Autowired
    private BlogArticleService service;

    @Autowired
    private ViewResolver viewResolver;

    @Resource(name = "pageParameterValidator")
    private Validator pageValidator;

    @RequestMapping(value = "/blogarticle/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("blogarticle/add_blogarticle");
        modelAndView.addObject("blogArticle", new BlogArticle());
        return modelAndView;
    }

    @RequestMapping(value = "/blogarticle/save")
    public ModelAndView save(@ModelAttribute BlogArticle blogArticle) {
        ModelAndView mav = new ModelAndView("home");
        service.save(blogArticle);

        String message = "save successfully";
        mav.addObject("message", message);
        return mav;
    }

    @RequestMapping(value = "/blogarticle/load/{id}", method = RequestMethod.GET)
    public ModelAndView load(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/blogarticle/edit_blogarticle");
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setTitle("cao");
        mav.addObject("blogarticle", blogArticle);
        return mav;
    }

    /**
     * 首页 列表
     */
    @RequestMapping(value = "/blogarticle/list", produces = "application/json;charset=utf-8")
    public
    @ResponseBody
    FrontEndListResult list(HttpServletRequest request, HttpServletResponse response, String pgIndex, String pgSize) {

        FrontEndListResult<BlogArticle> listResult = new FrontEndListResult();
        BlogArticle blogArticle=new Gson().fromJson(request.getParameter("blogArticle"), BlogArticle.class);
        if (!pageValidator.valid(request) || blogArticle == null) {
            listResult.setErrorMsg("BlogArticleController list method failed. The request parameters are not correct.");
            return listResult;
        }

        int currentPgIndex = Integer.parseInt(pgIndex);
        int currentPgSize = Integer.parseInt(pgSize);

        DaoListResult<BlogArticle> blogArticles = service.list(blogArticle, currentPgIndex, currentPgSize);
        //渲染页面
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("blogarticles", blogArticles.getDaoList());
        modelMap.put("pgCount", blogArticles.getRowCount());
        modelMap.put("pgIndex", currentPgIndex);
        modelMap.put("pgSize", currentPgSize);

        try {
            View view = this.viewResolver.resolveViewName("/blogarticle/list_blogarticle", Locale.CHINA);
            MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
            view.render(modelMap, request, mockHttpServletResponse);

            //设置回馈
            listResult.setHtml(mockHttpServletResponse.getContentAsString());
            listResult.setPgIndex(currentPgIndex);
            listResult.setPgCount(blogArticles.getRowCount());
            listResult.setPgSize(currentPgSize);
            listResult.setT(blogArticle);
        } catch (Exception e) {

        }
        return listResult;
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

    public void transfer() {

    }
}
