package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    // 예약 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/book")
    public String viewBook() {
        return "book_test_DB";
    }

    // 임시 결제 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/payment")
    public String viewPayment() {
        return "payment";
    }
}
