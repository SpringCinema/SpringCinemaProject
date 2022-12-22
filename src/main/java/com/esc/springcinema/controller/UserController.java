package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private MemberService memberService;

    // 로그인 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "login";
    }
    
    // 로그인전에 실패했을경우 페이지 이동하지않고 처리하기위해 테스트 로그인진행
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @ResponseBody
    @RequestMapping(value = "/user/testLogin", method = RequestMethod.POST)
    public String testLogin(@RequestParam("targetId") String targetId, @RequestParam("pwd") String pwd) throws Exception {
        MemberDto result = memberService.login(targetId, pwd);
        if (result != null) {
            if (result.getOutDate() == null) {
                return "true"; // 회원 탈퇴 유저가 아니면
            } else {
                return "false"; // 회원 탈퇴 유저인경우
            }
        } else {
            return "false";
        }
    }
    
    // 로그인 진행을합니다.
    // 세션에 아이디와 이름이 저장됩니다.
    // 아이디 저장을 위해서는 쿠기를 사용을 해야할것같으나 개인정보는 내릴수없기때문에 고민해봐야함
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam("targetId") String targetId, @RequestParam("pwd") String pwd,
        @RequestParam(value = "idSave") String idSave, HttpServletRequest request) throws Exception {

        MemberDto member = memberService.login(targetId, pwd);
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUserInfo", member);
        return "redirect:/main";
    }
    
    // 로그아웃
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("loggedInUserInfo");
        session.invalidate();

        ModelAndView view = new ModelAndView("common/process_complete");
        view.addObject("title", "스프링 시네마 - 로그아웃 완료");
        view.addObject("headMsg", "로그아웃이 완료되었습니다.");
        view.addObject("link", "/main");
        view.addObject("btnMsg", "메인으로");
        return view;
    }

    // 비밀번호 찾기 페이지
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @RequestMapping(value = "/findPwd")
    public ModelAndView findPWd() throws Exception {
        ModelAndView mv = new ModelAndView("pwdFind");
        return mv;
    }

    // 비밀번호 찾기 페이지 회원가입 정보 확인
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @ResponseBody
    @RequestMapping(value = "/chkJoinInfo", method = RequestMethod.POST)
    public Object ajaxChkInfo(@RequestParam("id") String id, @RequestParam("email") String email) throws Exception{
        int joinInfo = memberService.checkIdEmail(id, email);
        return joinInfo;
    }

    // 비밀번호 변경 페이지
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : yang
    @RequestMapping(value = "/pwdUpdate/{userId}", method = RequestMethod.GET)
    public ModelAndView updatePwdPage(@PathVariable String userId) throws Exception {
        ModelAndView mv = new ModelAndView("pwdUpdate");
        mv.addObject(userId);
        return mv;
    }

    // 비밀번호 변경 완료 페이지
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @RequestMapping(value = "/pwdUpdateOk", method = RequestMethod.POST)
    public ModelAndView updatePwd(@RequestParam("pwd") String pwd, @RequestParam("id") String id) throws Exception {
        memberService.pwdUpdate(pwd, id);
        ModelAndView mv = new ModelAndView("common/process_complete");
        mv.addObject("title", "비밀번호 설정 성공");
        mv.addObject("headMsg", "비밀번호를 성공적으로 변경하였습니다.");
        mv.addObject("link", "/main");
        mv.addObject("btnMsg", "메인으로");
        return mv;
    }
}
