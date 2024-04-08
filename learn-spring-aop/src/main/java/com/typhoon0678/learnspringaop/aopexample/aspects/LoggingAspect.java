package com.typhoon0678.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //    @Before("execution(* com.typhoon0678.learnspringaop.aopexample.*.*.*(..))")
    @Before("com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect {} - is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect {} - has executed", joinPoint);
    }

    @AfterThrowing(pointcut = "com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
            throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
            returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
    }


}
