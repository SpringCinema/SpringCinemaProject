package com.esc.springcinema.controller;

import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang

    @Autowired
    private CinemaService cinemaService;

    // 예약 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    @RequestMapping("/book")
    public ModelAndView viewBook() throws Exception{
        ModelAndView mv = new ModelAndView("book_test_DB");
        List<ScreenHallDto> allScreenTitle = cinemaService.allScreenTitle();
        mv.addObject("allScreenTitle", allScreenTitle);
        return mv;
    }

    // 임시 결제 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/payment")
    public String viewPayment() {
        return "payment";
    }
}
