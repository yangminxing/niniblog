package com.niniblog.action;

import com.niniblog.bean.User;
import com.niniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作类控制器
 */
@Controller
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;

    public ModelAndView login(HttpServletRequest request)
    {
        logger.debug("System login started.");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password))
        {

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
