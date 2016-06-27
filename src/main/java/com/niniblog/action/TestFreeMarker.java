package com.niniblog.action;

import com.niniblog.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yang on 2016/6/27.
 */
@Controller
public class TestFreeMarker {
    @RequestMapping("/testfree")
    public ModelAndView home()
    {
        ModelAndView modelAndView=new ModelAndView("/testfree");
        User user=new User();
        user.setId(2);
        user.setUsername("yang");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
