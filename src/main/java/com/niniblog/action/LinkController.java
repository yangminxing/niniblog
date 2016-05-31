package com.niniblog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2016/5/13.
 */
@Controller
public class LinkController {
    /**
     * 首页
     */
    @RequestMapping(value="/")
    public ModelAndView mainPage()
    {
        return new ModelAndView("home");
    }

    /**
     * 首页
     */
    @RequestMapping(value="/index")
    public ModelAndView indexPage()
    {
        return new ModelAndView("index");
    }
}

