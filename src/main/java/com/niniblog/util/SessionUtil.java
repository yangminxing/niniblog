package com.niniblog.util;

import com.niniblog.bean.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Session π§æﬂ¿‡
 */
public class SessionUtil {
    public static void newSession(HttpServletRequest request, String key,Object value)
    {
        request.getSession().setAttribute(key,value);
    }

    public static Object getSession(HttpServletRequest request,String key)
    {
        return request.getSession().getAttribute(key);
    }
}
