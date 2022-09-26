package com.sp.aop.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.aop.audit.Audit
 *
 * Date    : 26 September 2022
 * Version : 1.0
 **************************************/
@Component
@Slf4j
@Aspect
public class Audit {

    private List<String> list;
    @Before("execution(* com.sp.aop..*.*(..))")
    public void doBeforeAudit(JoinPoint joinPoint){
        log.info("Audit.doBeforeAudit called");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));

    }

    @After("execution(* com.sp.aop..*.*(..))")
    public void doAfterAudit(JoinPoint joinPoint){
        log.info("Audit.doAfterAudit called");
        list.clear();

    }

    @AfterThrowing("execution(* com.sp.aop..*.*(..))")
    public void afterThrowingAdvice(JoinPoint jp, Throwable error){
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception: "+error);
    }


    @AfterReturning(pointcut = "execution(* com.sp.aop..*.*(..))", returning="retVal")
    public void doAfterReturnningTask(Object retVal) {
        log.info("this response contain {} object",retVal.getClass().getName());
    }


}
