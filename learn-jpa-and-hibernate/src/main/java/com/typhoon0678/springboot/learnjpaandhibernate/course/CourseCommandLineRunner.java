package com.typhoon0678.springboot.learnjpaandhibernate.course;

import com.typhoon0678.springboot.learnjpaandhibernate.course.Course;
import com.typhoon0678.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.typhoon0678.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.typhoon0678.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));

        repository.deleteById(1L);


        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn Azure Jpa!"));
    }
}
