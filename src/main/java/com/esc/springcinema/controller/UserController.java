package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.service.MailService;
import com.esc.springcinema.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class UserController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MailService mailService;

    // 로그인 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public Object viewLogin(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);

        if (userId.equals("") == false) {
            return "redirect:/main";
        }

        ModelAndView view = new ModelAndView("/login");
        view.addObject("isLogin", "false");
        return view;
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
    public String login(@RequestParam("targetId") String targetId, @RequestParam("pwd") String pwd, HttpServletRequest request) throws Exception {
        MemberDto member = memberService.login(targetId, pwd);
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUserInfo", member);
        return "redirect:/main";
    }
    
    // 로그아웃
    // 최종 수정 : 2022-12-22
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
        view.addObject("isLogin", "false");
        return view;
    }

    // 비밀번호 찾기 페이지
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @RequestMapping(value = "/findPwd")
    public ModelAndView findPWd(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("pwdFind");
        return mv;
    }

    // 비밀번호 찾기 페이지 회원가입 정보 확인 / 인증번호 전송
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : yang
    @ResponseBody
    @RequestMapping(value = "/chkJoinInfo", method = RequestMethod.POST)
    public Object ajaxChkInfo(@RequestParam("id") String id, @RequestParam("email") String email, HttpServletRequest request) throws Exception{
//        인증번호 생성
        Random random = new Random();
        String resultNum = "";
        for(int i = 0; i < 10; i++) {
            int randomNum = random.nextInt(9);
            String randomVal = Integer.toString(randomNum);
            resultNum += randomVal;
        }
//        인증번호 세션 저장.
        HttpSession session = request.getSession();
        session.setAttribute("findPwdUser" + id, id);
        session.setAttribute("findPwdSecure" + id, resultNum);
        session.setMaxInactiveInterval(180);

//        아이디 이메일 정보 확인
        int joinInfo = memberService.checkIdEmail(id, email);

//        인증번호 발송
        String title = id + "님! spring cinema 비밀번호 인증 번호입니다.";
        String url = "인증번호 입력칸에 [" + resultNum + "]를 입력해 주세요";
        mailService.mailSend(email, title, url);
        return joinInfo;
    }

    // 비밀번호 변경 완료 페이지
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @RequestMapping(value = "/pwdUpdateOk", method = RequestMethod.POST)
    public ModelAndView updatePwd(@RequestParam("pwd") String pwd, @RequestParam("id") String id,@RequestParam("secureNum") String secureNum,
                                    HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("findPwdSecure" + id);
        try {
            if(sessionId.equals(secureNum) && sessionId != null) {
                memberService.pwdUpdate(pwd, id);
                ModelAndView mv = new ModelAndView("common/process_complete");
                mv.addObject("title", "비밀번호 설정 성공");
                mv.addObject("headMsg", "비밀번호를 성공적으로 변경하였습니다.");
                mv.addObject("link", "/user/login");
                mv.addObject("btnMsg", "로그인");
                session.removeAttribute("findPwdUser" + id);
                session.removeAttribute("findPwdSecure" + id);
                return mv;
            }
            else {
                ModelAndView mv = new ModelAndView("common/process_complete");
                mv.addObject("title", "비밀번호 설정 실패");
                mv.addObject("headMsg", "비밀번호변경에 실패했습니다.");
                mv.addObject("link", "/findPwd");
                mv.addObject("btnMsg", "돌아가기");
                session.removeAttribute("findPwdUser" + id);
                session.removeAttribute("findPwdSecure" + id);
                return mv;
            }
        }
        catch (NullPointerException e) {
            ModelAndView mv = new ModelAndView("common/process_complete");
            mv.addObject("title", "비밀번호 설정 실패");
            mv.addObject("headMsg", "인증번호가 만료되었습니다.");
            mv.addObject("link", "/findPwd");
            mv.addObject("btnMsg", "돌아가기");
            session.removeAttribute("findPwdUser" + id);
            session.removeAttribute("findPwdSecure" + id);
            return mv;
        }
    }
}
