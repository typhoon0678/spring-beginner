package com.typhoon0678.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    @Around("com.typhoon0678.learnspringaop.aopexample.aspects.CommonPointCutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimes = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTimes = System.currentTimeMillis();

        long executionDuration = stopTimes - startTimes;

        logger.info("Around Aspect - {} Method executed in {} ms", startTimes, executionDuration);

        return returnValue;
    }
}
