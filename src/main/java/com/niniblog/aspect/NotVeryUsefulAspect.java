package com.niniblog.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2016/5/17.
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

    @Pointcut("execution(public * com.niniblog.action.*.load(..))")
    private void load1()
    {

    }

    @Before("load1()")
    public void beforeCheck()
    {
        System.out.println("before transfer aspect");
    }

}
