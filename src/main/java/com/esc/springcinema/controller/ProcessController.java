package com.esc.springcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessController {

    // 특정작업이 처리가 완료되었을때의 뷰를 보여주는 기능을 해주는 함수
    // 메세지 타입에따라 다르게 처리가능
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @RequestMapping( value = "/complete")
    public ModelAndView viewProcessComplete(@RequestParam("msgType") String msgType) throws Exception {
        ModelAndView modelAndView = new ModelAndView("common/process_complete");
        String title = "";
        String headMsg = "";
        String btnMsg = "";
        String link = "";

        switch (msgType) {
            case "UserDeleted" :
            title = "스프링 시네마 - 회원탈퇴 완료";
            headMsg = "회원탈퇴가 완료되었습니다.";
            btnMsg = "메인으로";
            link = "/main";
            break;
            case "payCancel" :
                title = "스프링 시네마 - 결제취소 완료";
                headMsg = "결제취소가 완료되었습니다.";
                btnMsg = "마이페이지로";
                link = "/mypage";
            break;
        }

        modelAndView.addObject("title", title); // 제목
        modelAndView.addObject("headMsg", headMsg); // 머리글
        modelAndView.addObject("btnMsg", btnMsg); // 버튼에 들어갈 내용
        modelAndView.addObject("link", link); // 버튼에 연결되는 링크

        return modelAndView;
    }

    // 특정 페이지가 아직 미완성일때 임시로 보여주는 페이지
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/construction", method = RequestMethod.GET)
    public String viewConstruction() {
        return "/common/construction";
    }
}
