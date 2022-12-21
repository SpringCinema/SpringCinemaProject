package com.esc.springcinema.controller;
import com.esc.springcinema.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MailController {
    private final MailService mailService;


    @RequestMapping(value = "/sendSuccess", method = RequestMethod.POST)
    public ModelAndView sendSuccess(@RequestParam("email") String address,@RequestParam("id") String userId) {
        String id = userId;
        String email = "ymh0052@naver.com";
        String title = id + "님! spring cinema 비밀번호 찾기 링크입니다.";
        String url = "http://localhost:8080/pwdUpdate/" + address;
        mailService.mailSend(email, title, url);
        ModelAndView mv = new ModelAndView("common/process_complete");
        mv.addObject("title", "이메일전송 완료");
        mv.addObject("headMsg", "가입하신 이메일로 비밀번호 찾기링크를 보냈습니다. 이메일을 확인해주세요.");
        mv.addObject("link", "/user/login");
        mv.addObject("btnMsg", "로그인");
        return mv;
    }

}