package com.cms.cloud.api.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CmsCloudJobs {

    @Scheduled(cron = "0 */1 * ? * *")
    public void runEvey5Minutes() {
        System.out.println("Current time is :: " + LocalDateTime.now());
    }
}