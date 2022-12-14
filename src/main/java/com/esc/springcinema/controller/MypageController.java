package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {

//    마이 페이지
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public ModelAndView openMyPage() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/mypage");
        return mv;
    }

//    내 정보 수정
    @RequestMapping(value = "/mypage/update", method = RequestMethod.GET)
    public ModelAndView updateProfile() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_update");
        return mv;
    }

//    회원 탈퇴
    @RequestMapping(value = "/mypage/delete", method = RequestMethod.GET)
    public ModelAndView deleteProfile() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_delete");
        return mv;
    }

//    결제 취소
    @RequestMapping(value = "/mypage/paycancle", method = RequestMethod.GET)
    public ModelAndView cancelPay() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/payment_cancel");
        return mv;
    }

//    좌석 선택
    @RequestMapping(value = "/seat" , method = RequestMethod.GET)
    public ModelAndView openSeat() throws Exception {
        ModelAndView mv = new ModelAndView("movieseat");

        List<Integer> people = new ArrayList<>();
        people.add(0);
        people.add(1);
        people.add(2);
        people.add(3);
        people.add(4);
        people.add(5);

        List<String> seatCode = new ArrayList<>();
        seatCode.add("A");
        seatCode.add("B");
        seatCode.add("C");
        seatCode.add("D");
        seatCode.add("E");
        seatCode.add("F");
        seatCode.add("G");
        seatCode.add("H");
        seatCode.add("I");
        seatCode.add("J");


        mv.addObject("alp", seatCode);
        mv.addObject("people", people);
        return mv;
    }
}
