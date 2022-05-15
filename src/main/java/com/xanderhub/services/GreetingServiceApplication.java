package com.xanderhub.services;

import com.xanderhub.services.businesslogic.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingServiceApplication {

    @Autowired
    public GreetingServiceApplication(GreetingService greetingService) {
        greetingService.greet();
    }

    public static void main(String[] args) {
        SpringApplication.run(GreetingServiceApplication.class, args);
    }
}

