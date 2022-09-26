package com.sp.aop.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.aop.audit.Logger
 *
 * Date    : 26 September 2022
 * Version : 1.0
 **************************************/
@Aspect
@Component
@Slf4j
public class Logger {

    @Around("execution(* com.sp.aop..*.*(..))")
    public Object doLog(ProceedingJoinPoint point) throws Throwable{
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();
        log.info("{}.{} started::",className,methodName);
        //Measure method execution time
        stopWatch.start();
        Object result = point.proceed();
        stopWatch.stop();

        //Log method execution time
        log.info("Execution time of {}.{} :: {} ms",  className, methodName , stopWatch.getTotalTimeMillis());

        return result;
    }

}
