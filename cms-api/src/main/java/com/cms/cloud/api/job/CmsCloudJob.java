package com.cms.cloud.api.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CmsCloudJob {
    @Autowired
    private JavaMailSender emailSender;

    @Value("${email.from}")
    private String emailFrom;

    @Value("${email.to}")
    private String emailTo;

   // @Scheduled(cron = "0 */1 * ? * *")
    public void sendEmailEvery5Minutes() {
        //email kodu başlangıç
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailTo);
        message.setSubject("test emaili");
        message.setText("test içerik");
        emailSender.send(message);
        //email kodu bitiş
        System.out.println("Email Sent Time : " + LocalDateTime.now());
    }
}