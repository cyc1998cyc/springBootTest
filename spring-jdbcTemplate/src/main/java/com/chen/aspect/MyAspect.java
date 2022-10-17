package com.chen.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//这个注解能够将这个类定义成一个切面
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(public * com.chen..*(..))")
    public void pointCut(){
        System.out.println("切入点");
    }

    @Before("pointCut()")
    private void BeforeAdvice(){
        System.out.println("this is before advice");
    }


}
