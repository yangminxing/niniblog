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
     * ��ҳ
     */
    @RequestMapping(value="/")
    public ModelAndView mainPage()
    {
        return new ModelAndView("home");
    }

    /**
     * ��ҳ
     */
    @RequestMapping(value="/index")
    public ModelAndView indexPage()
    {
        return new ModelAndView("index");
    }
}

