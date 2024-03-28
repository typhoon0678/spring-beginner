package com.typhoon0678.learnspringframework.example.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class);

        System.out.println();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
