package com.shev8987.spring.demo;

import org.springframework.boot.SpringApplication;

public class TestSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
