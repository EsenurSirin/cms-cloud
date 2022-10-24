package com.cms.cloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApiApplication.class, args);
    }
}
