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

    @RequestMapping("/main")
    public String viewMain() {
        return "main";
    }
}
