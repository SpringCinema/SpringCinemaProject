package com.esc.springcinema.service;


import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "springcinema@naver.com";

    public void mailSend(String email,String title,String url) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(title);
        message.setText(url);

        mailSender.send(message);
    }
}
