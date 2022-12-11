package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public ModelAndView openMyPage() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/mypage");
        return mv;
    }

    @RequestMapping(value = "/mypage/update", method = RequestMethod.GET)
    public ModelAndView updateProfile() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_update");
        return mv;
    }

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


        mv.addObject("alp", seatCode);
        mv.addObject("people", people);
        return mv;
    }
}
