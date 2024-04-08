package com.typhoon0678.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.typhoon0678.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.typhoon0678.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.typhoon0678.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.typhoon0678.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {

    }
}
