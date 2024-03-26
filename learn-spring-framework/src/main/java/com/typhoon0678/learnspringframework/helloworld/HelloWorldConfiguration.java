package com.typhoon0678.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Getter, Setter가 자동으로 생성되는 Class recode (Java 16 이상)
record Person (String name, int age, Address address) {}
record Address (String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Main street", "Utrecht"));
    }

    // Bean 재활용
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // Parameter로 Bean 가져오기
    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary // 같은 유형의 빈들이 있을 때, 우선 선택됨
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    @Primary // 같은 유형의 빈들이 있을 때, 우선 선택됨
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Primary // 같은 유형의 빈들이 있을 때, 우선 선택됨
    public Address address() {
        return new Address("Baker Street", "London");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Motinagar", "Hyderabad");
    }
}
