package com.hoxton.big4static;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Big4StaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Big4StaticApplication.class, args);
    }

}
