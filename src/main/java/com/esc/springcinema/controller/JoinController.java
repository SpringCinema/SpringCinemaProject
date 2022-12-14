package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.service.MemberService;
import com.esc.springcinema.service.MemberServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JoinController {
    @Autowired
    private MemberService memberService;
    
    // 약관 동의 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/clause")
    public String viewClause() {
        return "clause";
    }

    // 회원가입 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/join" , method = RequestMethod.GET)
    public String viewJoin() {
        return "join";
    }
    
    // 이미 사용중인 아이디가 있는지 확인
    @ResponseBody
    @RequestMapping(value = "/join/user/{targetId}", method = RequestMethod.GET)
    public String isUserId(@PathVariable String targetId) throws Exception {
        boolean result = memberService.isUserId(targetId);
        return "isUserData {value=" + result + "}";
    }
    
    // 회원가입진행
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ModelAndView createMember(HttpServletRequest request) throws Exception {
        MemberDto member = new MemberDto();
        
        request.setCharacterEncoding("UTF-8");
        member.setId(request.getParameter("id"));
        member.setPwd(request.getParameter("pwd"));
        member.setName(request.getParameter("name"));
        member.setBirth(request.getParameter("birth"));
        member.setGender(request.getParameter("gender"));
        member.setEmail(request.getParameter("email"));
        member.setTel(request.getParameter("tel"));
        
        boolean result = memberService.createMember(member);
        
        ModelAndView resultView = new ModelAndView("common/process_complete");
        if (result == true) {
            resultView.addObject("title", "스프링 시네마 - 회원가입 완료");
            resultView.addObject("headMsg", "회원가입이 완료되었습니다.");
            resultView.addObject("link", "/main");
            resultView.addObject("btnMsg", "메인으로");
            
            return resultView;
        } else { // 실패시 처리 필요
            return resultView;
        }
    }
}
