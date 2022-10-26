package com.cms.cloud.api.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendmail")
public class MailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping( "/send-sendmail" )
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ese.siri@gmail.com");
        message.setTo("ese.siri@gmail.com");
        message.setSubject("test emaili");
        message.setText("test içerik");
        emailSender.send(message);

    }
}