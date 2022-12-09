package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CinemaController {

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
}
