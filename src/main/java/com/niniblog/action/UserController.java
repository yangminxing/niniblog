package com.niniblog.action;

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
@RestController
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public FrontEndResult login(HttpServletRequest request)
    {
        logger.debug("System login started.");

        FrontEndResult frontEndResult=new FrontEndResult();

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password))
        {
            frontEndResult.setErrorMsg("username or password could be null");
            return;
        }

        User vUser=new User();
        vUser.setUsername(username);
        User vUser2= (User)userDao.findByExample(vUser);
        if(vUser)

            if(vUser2.getPassword()==null)
            {
                logger.error("This user named:"+username+" don't not have a password.");
                return false;
            }
        if(vUser2.getPassword().equals(password))
        {
            session.setAttribute("user",);

            logger.debug("This user named:"+username+" logged success");
            return true;
        }

        logger.debug("This user named:"+username+" logged failed");
        return false;
    }
}
