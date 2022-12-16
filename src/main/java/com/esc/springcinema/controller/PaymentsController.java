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

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView createMember(HttpServletRequest request) throws Exception {
        PaymentsDto payment = new PaymentsDto();

        boolean result = paymentService.paymentComplete(payment);
        ModelAndView resultView = new ModelAndView("common/process_complete");
        if (result == true) { // 아이디가 올바르게 들어갔는지 검증하는 기능이 아직 구현되지않음 무조건 true
            resultView.addObject("title", "스프링 시네마 - 예매 완료");
            resultView.addObject("headMsg", "예매가 완료되었습니다.");
            resultView.addObject("link", "/main");
            resultView.addObject("btnMsg", "메인으로");
        } else {
            resultView.addObject("title", "스프링 시네마 - 예매 실패");
            resultView.addObject("headMsg", "예매 결제 도중 문제가 발생했습니다.");
            resultView.addObject("link", "/main");
            resultView.addObject("btnMsg", "메인으로");
        }

        return resultView;
    }


}
