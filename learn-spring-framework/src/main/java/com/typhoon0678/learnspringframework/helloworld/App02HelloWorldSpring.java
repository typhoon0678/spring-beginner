package com.typhoon0678.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        // 1. 스프링 콘텍스트 실행
        try(var context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. 스프링에서 관리할 것 설정 @Configuration -> name - @Bean

            // 3. 스프링으로 관리되는 빈 검색
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person4Parameters"));
            System.out.println(context.getBean("person5Qualifier"));

            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class)); // @Primary로 우선순위를 지정했기 때문에 오류 발생 X

            // 모든 Bean 출력
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }

}
