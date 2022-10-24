package com.cms.cloud.api.job;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

public class CmsCloudJobs {

    @Scheduled(cron = "0 */5 * ? * *")
    public void runEvey5Minutes() {
        System.out.println("Current time is :: " + LocalDate.now());
    }
}