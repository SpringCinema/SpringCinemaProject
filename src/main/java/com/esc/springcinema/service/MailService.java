package com.esc.springcinema.service;


import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// 비밀번호 변경 페이지 주소 메일보내기
// 최종 수정 : 2022-12-21
// 마지막 작성자 : yang
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
