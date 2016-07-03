package com.niniblog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Yang on 2016/7/2.
 */
@Component
public class PageParameterValidtor implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(HttpServletRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(o==null)
        {
            errors.rejectValue("A1","B1","C11");
        }
        HttpServletRequest sp=(HttpServletRequest)o;
        try
        {
            Integer.valueOf(sp.getParameter("pg_index"));
        }
        catch (Exception e)
        {
            errors.rejectValue("A11","B11"+e.toString());
        }
    }
}
