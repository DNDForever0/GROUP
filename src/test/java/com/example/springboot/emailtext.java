package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class emailtext {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void email(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("团员您好！");
        mailMessage.setText("团已开，请及时参加");
        mailMessage.setTo("1377682584@qq.com");
        mailMessage.setFrom("1377682584@qq.com");
        mailSender.send(mailMessage);
    }
}
