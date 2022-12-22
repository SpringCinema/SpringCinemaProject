package com.esc.springcinema.controller;
import com.esc.springcinema.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// 비밀번호 변경 페이지 주소 메일보내기
// 최종 수정 : 2022-12-21
// 마지막 작성자 : yang
@Controller
@AllArgsConstructor
public class MailController {
    private final MailService mailService;


    @RequestMapping(value = "/sendSuccess", method = RequestMethod.POST)
    public ModelAndView sendSuccess(@RequestParam("email") String address, @RequestParam("id") String userId) {
        String title = userId + "님! spring cinema 비밀번호 찾기 링크입니다.";
        String url = "http://localhost:8080/pwdUpdate/" + userId;
        mailService.mailSend(address, title, url);
        ModelAndView mv = new ModelAndView("common/process_complete");
        mv.addObject("title", "이메일전송 완료");
        mv.addObject("headMsg", "가입하신 이메일로 비밀번호 찾기링크를 보냈습니다. 이메일을 확인해주세요.");
        mv.addObject("link", "/main");
        mv.addObject("btnMsg", "홈페이지");
        return mv;
    }

}