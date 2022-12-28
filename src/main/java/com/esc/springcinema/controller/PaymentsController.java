package com.esc.springcinema.controller;

import com.esc.springcinema.service.MemberService;
import com.esc.springcinema.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;

@Controller
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private MemberService memberService;
    
    // 결제 완료 후 DB 저장 & 페이지 이동
    // 최종 수정 : 2022-12-28
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/paymentComplete", method = RequestMethod.GET)
    public ModelAndView addPayment(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";
        
        if (userId.equals("") == false) {
            isLogin = "true";
        }
        
        ModelAndView resultView = new ModelAndView("common/process_complete");
        resultView.addObject("title", "SPRING CINEMA - 예매 완료");
        resultView.addObject("headMsg", "예매가 완료되었습니다.");
        resultView.addObject("link", "/main");
        resultView.addObject("btnMsg", "메인으로");
        resultView.addObject("isLogin", isLogin);
        return resultView;
    }


    // 결제 실패 후 페이지 이동
    // 최종 수정 : 2022-12-28
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/paymentCancel", method = RequestMethod.GET)
    public ModelAndView paymentCancel(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";
    
        if (userId.equals("") == false) {
            isLogin = "true";
        }
        
        ModelAndView resultView = new ModelAndView("common/process_complete");
        resultView.addObject("title", "SPRING CINEMA - 예매 실패");
        resultView.addObject("headMsg", "예매 결제가 완료되지 않았습니다.");
        resultView.addObject("link", "/main");
        resultView.addObject("btnMsg", "메인으로");
        resultView.addObject("isLogin", isLogin);
        return resultView;
    }

}