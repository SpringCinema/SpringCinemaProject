package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    // 로그인 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/login")
    public String viewLogin() {
        return "login";
    }
}
