package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.mapper.CinemaMapper;
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
    @RequestMapping(value = "/mypage/{id}", method = RequestMethod.GET)
    public ModelAndView openMyPage(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/mypage");

        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }

//    (DB 적용)
//    내 정보 수정 (뷰)
    @RequestMapping(value = "/mypage/edit/{id}", method = RequestMethod.GET)
    public ModelAndView updateProfile(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_update");
        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }


//    (DB 적용)
//    내 정보 수정 (수정 기능)
//    추후 redirect mypage로
    @RequestMapping(value = "/mypage/update/{id}", method = RequestMethod.PUT)
    public String updateMyInfo(MemberDto update) throws Exception{
        cinemaService.updateMyInfo(update);

        return "redirect:/seat";
    }

//    (DB 적용)
//    회원 탈퇴 (뷰)
    @RequestMapping(value = "/mypage/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProfile(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView("mypage/profile_delete");
        MemberDto myInfo = cinemaService.selectMyInfo(id);
        mv.addObject("myInfo", myInfo);
        return mv;
    }

//    (DB 적용)
//    회원 탈퇴 (기능)
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

//    좌석 선택
    @RequestMapping(value = "/seat" , method = RequestMethod.GET)
    public ModelAndView openSeat() throws Exception {
        ModelAndView mv = new ModelAndView("movieseat");

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
        return mv;
    }
}
