package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/book")
    public String viewBook() {
        return "book";
    }

    @RequestMapping("/payment")
    public String viewPayment() {
        return "payment";
    }
}
