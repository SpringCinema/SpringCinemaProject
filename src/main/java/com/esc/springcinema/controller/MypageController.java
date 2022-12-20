package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {

    @Autowired
    private CinemaService cinemaService;


//    DB 적용
//    마이 페이지
//    2022-12-15 양민호
//    임시적으로 id를 직접 입력한 마이페이지로 이동하게 설계. 추후 sesssion 값 받아오기
    @RequestMapping(value = "/mypage/{id}", method = RequestMethod.GET)
    public ModelAndView openMyPage(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/mypage");

        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }

//    (DB 적용)
//    내 정보 수정 (뷰)
    @RequestMapping(value = "/mypage/update", method = RequestMethod.POST)
    public ModelAndView updateProfile(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_update");
        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }


//    (DB 적용)
//    2022-12-15 양민호
//    내 정보 수정 (수정 기능)
    @RequestMapping(value = "/mypage/update/{id}", method = RequestMethod.PUT)
    public String updateMyInfo(MemberDto update) throws Exception{
        cinemaService.updateMyInfo(update);

        return "redirect:/seat";
    }

//    (DB 적용)
//    회원 탈퇴 (뷰)
    @RequestMapping(value = "/mypage/delete", method = RequestMethod.POST)
    public ModelAndView deleteProfile(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_delete");
        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }

//    2022-12-15 양민호
//    (ajax + DB 적용) 탈퇴 페이지 비밀번호 확인 기능.
    @ResponseBody
    @RequestMapping(value = "/mypage/delete/checkPwd", method = RequestMethod.POST)
    public Object ajaxPwdCheck(@RequestParam("myid") String myid, @RequestParam("inputpwd") String inputpwd) throws Exception {
        int chkPwd = cinemaService.checkPwd(myid, inputpwd);
        return chkPwd;
    }
//    (DB 적용)
//    2022-12-15 양민호
//    회원 탈퇴 (기능) 추후 경로 mypage로 변경 필요
    @RequestMapping(value = "/mypage/out/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(MemberDto delete) throws Exception{
        cinemaService.deleteAccount(delete);

        return "redirect:/seat";
    }


//    결제 취소
    @RequestMapping(value = "/mypage/paycancle", method = RequestMethod.GET)
    public ModelAndView cancelPay() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/payment_cancel");
        return mv;
    }

//    (DB 적용)
//    2022-12-16 양민호
//    book 페이지에서 입력값을 받아오는 좌석 선택 페이지 뷰
//    현재 book 페이지에 date 와 time값을 제외하고 임의의 고정된 값 받아오고 있음.
    @RequestMapping(value = "/seat" , method = RequestMethod.POST)
    public ModelAndView openSeat(@RequestParam("movieTitle") String movieTitle, @RequestParam("cinemaName") String cinemaName, @RequestParam("inputDate") String date,
                                @RequestParam("screenHallName") String screenHallName, @RequestParam("inputTime") String screenTime,
                                @RequestParam("docid") String docid) throws Exception {
        ModelAndView mv = new ModelAndView("movieseat");

        ScreenHallDto selectScreenData = cinemaService.selectScreenData(movieTitle, cinemaName, screenHallName);


        String viewTime = screenTime;
        String screenDate = date;
        docid = docid;


        List<Integer> people = new ArrayList<>();
        people.add(0);
        people.add(1);
        people.add(2);
        people.add(3);
        people.add(4);
        people.add(5);

        List<String> seatCode = new ArrayList<>();
        seatCode.add("A");
        seatCode.add("B");
        seatCode.add("C");
        seatCode.add("D");
        seatCode.add("E");
        seatCode.add("F");
        seatCode.add("G");
        seatCode.add("H");
        seatCode.add("I");
        seatCode.add("J");


        mv.addObject("alp", seatCode);
        mv.addObject("people", people);
        mv.addObject("viewTime", viewTime);
        mv.addObject("screenDate", screenDate);
        mv.addObject("screenData", selectScreenData);
        mv.addObject("docid", docid);
        return mv;
    }
}
