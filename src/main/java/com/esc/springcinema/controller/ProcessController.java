package com.esc.springcinema.controller;

import com.esc.springcinema.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProcessController {
    @Autowired
    private MemberService memberService;

    // 특정작업이 처리가 완료되었을때의 뷰를 보여주는 기능을 해주는 함수
    // 메세지 타입에따라 다르게 처리가능
    // 최종 수정 : 2022-12-28
    // 마지막 작성자 : MoonNight285
    @RequestMapping( value = "/complete")
    public ModelAndView viewProcessComplete(@RequestParam("msgType") String msgType, HttpServletRequest request) throws Exception {
        String isLogin = "false";
        String userId = memberService.getLoggedInUserId(request);

        if (userId.equals("") == false) {
            isLogin = "true";
        }

        String title = "";
        String headMsg = "";
        String btnMsg = "";
        String link = "";

        switch (msgType) {
            case "UserDeleted" :
            title = "SPRING CINEMA - 회원탈퇴 완료";
            headMsg = "회원탈퇴가 완료되었습니다.";
            btnMsg = "메인으로";
            link = "/main";
            break;
            case "payCancel" :
                title = "SPRING CINEMA - 결제취소 완료";
                headMsg = "결제취소가 완료되었습니다.";
                btnMsg = "마이페이지로";
                link = "/mypage";
            break;
        }

        ModelAndView modelAndView = new ModelAndView("common/process_complete");
        modelAndView.addObject("title", title); // 제목
        modelAndView.addObject("headMsg", headMsg); // 머리글
        modelAndView.addObject("btnMsg", btnMsg); // 버튼에 들어갈 내용
        modelAndView.addObject("link", link); // 버튼에 연결되는 링크
        modelAndView.addObject("isLogin", isLogin); // 로그인 여부

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
