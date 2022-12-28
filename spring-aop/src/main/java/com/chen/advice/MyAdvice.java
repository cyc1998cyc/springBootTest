package com.chen.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 陈宇超
 * 13:58
 */
@Aspect
@Component
public class MyAdvice {
    private Logger logger = LoggerFactory.getLogger(MyAdvice.class);


    @Pointcut(value = "execution(* com.chen.controller.*.*(..))")
    public void myPointCut(){}


    @Around("myPointCut()")
    public Object myLogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] array = pjp.getArgs();

        logger.info("调用前");
        Object proceed = pjp.proceed();
        return null;

    }
}
