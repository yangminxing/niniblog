package com.niniblog.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yang on 2016/7/6.
 */
@Component
public class PageParameterValidator implements Validator
{
    private static final String PAGE_INDEX_NAME = "pgIndex";
    private static final String PAGE_COUNT_NAME = "pgCound";
    private static final String PAGE_SIZE_NAME = "pgSize";
    @Override
    public boolean valid(Object object) {
        if(!(object instanceof HttpServletRequest))
        {
            return false;
        }

        HttpServletRequest request=(HttpServletRequest)object;

        try {
            if (StringUtils.isEmpty(request.getParameter(PAGE_INDEX_NAME))||
                   // StringUtils.isEmpty(request.getParameter(PAGE_COUNT_NAME))||
                    StringUtils.isEmpty(request.getParameter(PAGE_SIZE_NAME))) {
                return false;
            }

            Integer.valueOf(request.getParameter(PAGE_INDEX_NAME).toString());
            //Integer.valueOf(request.getParameter(PAGE_COUNT_NAME).toString());
            Integer.valueOf(request.getParameter(PAGE_SIZE_NAME).toString());

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
