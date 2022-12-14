package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

//    영화 - 현재 상영작 페이지 접속
    @RequestMapping("/nowplaying")
    public String openMain() throws Exception {
        return "nowplaying";
    }

}
