package com.niniblog.action;

import com.niniblog.bean.BlogArticle;
import com.niniblog.bean.User;
import com.niniblog.result.FrontEndResult;
import com.niniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作类控制器
 */
@Controller
public class UserRestController extends BaseController
{
    @Autowired
    private UserService userService;


    /**
     * 登录验证
     */
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8" )
    public FrontEndResult login(HttpServletRequest request)
    {
        logger.debug("System login started.");

        FrontEndResult frontEndResult=new FrontEndResult();

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password))
        {
            frontEndResult.setErrorMsg("username or password could be null");
            return frontEndResult;
        }

        User vUser=new User();
        vUser.setUsername(username);
        User vUser2= userService.find(vUser);
        if(vUser2==null)
        {
            frontEndResult.setErrorMsg("User is not exists");
            return frontEndResult;
        }

        if(vUser2.getPassword()==null) {
            frontEndResult.setErrorMsg("Password is not correct");
            return frontEndResult;
        }
        if(vUser2.getPassword().equals(password))
        {
            request.getSession().setAttribute("user", vUser2);
            logger.debug("This user named:"+username+" logged success");
            //clear password
            vUser2.setPassword("Not try to get a password");
            frontEndResult.setContent(vUser2);
        }
        else {
            frontEndResult.setErrorMsg("Password is not correct");
        }
        return frontEndResult;
    }

    /**
     * 登出
     */
    @RequestMapping(value="/loginout",produces = "application/json;charset=utf-8")
    public FrontEndResult loginout(HttpServletRequest request)
    {
        logger.debug("System loginout started.");

        if(request.getSession().getAttribute("user")!=null)
        {
            request.getSession().removeAttribute("user");
        }

        logger.debug("System loginout end.");
        return new FrontEndResult(){
            @Override
            public Object getContent() {
                return "true";
            }
        };
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8")
    public ModelAndView register(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("/index");

        mav.addObject("user",new User());
        return mav;
    }
}
