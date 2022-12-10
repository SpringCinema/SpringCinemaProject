package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CinemaController {

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public ModelAndView openMyPage() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/mypage");
        return mv;
    }
}
