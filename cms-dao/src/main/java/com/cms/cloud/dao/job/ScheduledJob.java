package com.cms.cloud.dao.job;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

public class ScheduledJob {

    @Scheduled(cron = "0 */5 * ? * *")
    public void runEvey5Minutes() {
        System.out.println("Current time is :: " + LocalDate.now());
    }
}
