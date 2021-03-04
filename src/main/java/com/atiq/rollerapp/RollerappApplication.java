package com.atiq.rollerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RollerappApplication {

    public static void main(String[] args) {
        SpringApplication.run(RollerappApplication.class, args);
    }
}