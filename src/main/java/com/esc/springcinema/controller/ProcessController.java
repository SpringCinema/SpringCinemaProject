package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessController {

    // 특정작업이 처리가 완료되었을때의 뷰를 보여주는 기능을 해주는 함수
    // 매개변수를 아직 작성하지 않았습니다. 추후 업데이트 필요
    // 최종 수정 : 2022-12-13
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/complete")
    public ModelAndView viewProcessComplete() {

        ModelAndView modelAndView = new ModelAndView("common/process_complete");
        modelAndView.addObject("title", "임시제목입니다.");
        modelAndView.addObject("headMsg", "여기에 메세지 내용이 들어갑니다.");
        modelAndView.addObject("btnMsg", "내용삽입");
        modelAndView.addObject("link", "#");
        return modelAndView;
    }
}
