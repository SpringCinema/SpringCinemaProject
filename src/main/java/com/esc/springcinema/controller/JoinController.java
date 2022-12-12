package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {

    @RequestMapping("/clause")
    public String viewClause() {
        return "clause";
    }

    @RequestMapping("/join")
    public String viewJoin() {
        return "join";
    }
}
