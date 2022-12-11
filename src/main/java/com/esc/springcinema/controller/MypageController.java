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
}
