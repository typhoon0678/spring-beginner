package com.typhoon0678.learnspringframework.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy // Bean을 직접 사용하기 전까지 초기화하지 않음
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);

        System.out.println("Initialization of context is completed");

        context.getBean(ClassB.class).doSomething();

    }

}
