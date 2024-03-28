package com.typhoon0678.learnspringframework.example.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }

    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

}

@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class).getDataService());
    }

}
