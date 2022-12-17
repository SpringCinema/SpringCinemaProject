package com.esc.springcinema.controller;

import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.service.MemberService;
import com.esc.springcinema.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;
    
    // 결제 완료 후 페이지 이동
    // 최종 수정 : 2022-12-17
    // 마지막 작성자 : EblynCho
    @RequestMapping(value = "/paymentComplete", method = RequestMethod.GET)
    public ModelAndView paymentComplete(HttpServletRequest request) throws Exception {
//        PaymentsDto payment = new PaymentsDto();
//
//        boolean result = paymentService.paymentComplete(payment);
        ModelAndView resultView = new ModelAndView("common/process_complete");
//        if (result == true) {
            resultView.addObject("title", "스프링 시네마 - 예매 완료");
            resultView.addObject("headMsg", "예매가 완료되었습니다.");
            resultView.addObject("link", "/main");
            resultView.addObject("btnMsg", "메인으로");
//        }
        return resultView;
    }

    // 결제 실패 후 페이지 이동
    // 최종 수정 : 2022-12-17
    // 마지막 작성자 : EblynCho
    @RequestMapping(value = "/paymentCancel", method = RequestMethod.GET)
    public ModelAndView paymentCancel(HttpServletRequest request) throws Exception {
        ModelAndView resultView = new ModelAndView("common/process_complete");
            resultView.addObject("title", "스프링 시네마 - 예매 실패");
            resultView.addObject("headMsg", "예매 결제 도중 문제가 발생했습니다.");
            resultView.addObject("link", "/main");
            resultView.addObject("btnMsg", "메인으로");
        return resultView;
    }

}
