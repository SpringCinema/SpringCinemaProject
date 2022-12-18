package com.esc.springcinema.controller;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.service.CinemaService;
import com.esc.springcinema.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {

    @Autowired
    private CinemaService cinemaService;
    
    @Autowired
    private MypageService mypageService;
    
//    DB 적용
//    마이 페이지에 세션을 이용해서 접속하도록 변경(현재 사용하는 세션방식은 불완전함)
//    2022-12-16 MoonNight285
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public ModelAndView openMyPage(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        ModelAndView mv = new ModelAndView("mypage/mypage");
        MemberDto myInfo = mypageService.selectMyInfo(loggedInUserId);
        mv.addObject("myInfo", myInfo);
        
        return mv;
    }
    
    // 마이페이지의 영화예매내역 중 예매중인 영화목록 표시
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/book/normal", method = RequestMethod.GET)
    public ModelAndView getNormalBookList(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        List<BooksDto> bookList = mypageService.selectBookList(loggedInUserId, "Y");
        ModelAndView view = new ModelAndView("mypage/mypage_book");
        view.addObject("bookList", bookList);
        view.addObject("bookTitle", "예매내역");
        view.addObject("selected", "active");
        view.addObject("bookType", "normal");
        
        return view;
    }
    
    // 마이페이지의 영화예매내역 중 예매 취소된 영화목록 표시
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/book/cancellation", method = RequestMethod.GET)
    public ModelAndView getCancellationBookList(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        List<BooksDto> bookList = mypageService.selectBookList(loggedInUserId, "N");
        ModelAndView view = new ModelAndView("mypage/mypage_book");
        view.addObject("bookList" , bookList);
        view.addObject("bookTitle", "취소내역");
        view.addObject("bookType", "cancellation");
    
        return view;
    }
    
    // 마이페이지에서 로그인한 내 정보를 보여주는 기능
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/userInfo", method = RequestMethod.GET)
    public ModelAndView getUserInfo(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        MemberDto member = mypageService.selectMyInfo(loggedInUserId);
        ModelAndView view = new ModelAndView("mypage/mypage_profile");
        view.addObject("myInfo", member);
        view.addObject("profileTitle", "내 프로필");
        
        return view;
    }

    // 마이페이지에서 내가 결제한 내역을 보여주는 기능
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/payment", method = RequestMethod.GET)
    public ModelAndView getPaymentList(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        PaymentsDto payment = mypageService.selectMyPayment(loggedInUserId);
        ModelAndView view = new ModelAndView("/mypage/mypage_payment");
        view.addObject("payment", payment);
        view.addObject("paymentTitle", "결제내역");

        return view;
    }

    // 마이페이지에서 내가 작성한 댓글목록을 표시
    // 미완성, DB에서 가져오는 기능은 추가되지않음
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/comment", method = RequestMethod.GET)
    public ModelAndView getCommentList(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        // DB에서 가져오는 댓글목록 가져오는기능 추후 추가바람..
        ModelAndView view = new ModelAndView("/mypage/mypage_comment");
        view.addObject("commentTitle", "댓글내역");

        return view;
    }

    // 마이페이지에서 내가 작성한 문의내역을 표시
    // 미완성, DB에서 가져오는 기능은 추가되지않음
    // 최종 수정일 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @RequestMapping(value = "/mypage/question", method = RequestMethod.GET)
    public ModelAndView getQuestion(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        // DB에서 가져오는 문의목록 추후 추가바람..
        ModelAndView view = new ModelAndView("/mypage/mypage_question");
        view.addObject("questionTitle", "문의내역");

        return view;
    }

    // (DB 적용)
    // 내 정보 수정 (뷰)
    // 내 프로필에서 내 정보 수정을 눌렀을때 뷰를 내려준다.
    // 최종 수정일 : 2022-12-17
    @RequestMapping(value = "/mypage/update", method = RequestMethod.GET)
    public ModelAndView updateProfile(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        ModelAndView mv = new ModelAndView("mypage/profile_update");
        MemberDto myInfo = mypageService.selectMyInfo(loggedInUserId);
        mv.addObject("myInfo", myInfo);
        mv.addObject("profileTitle", "내 정보 수정");

        return mv;
    }


//    (DB 적용)
//    2022-12-15 양민호
//    내 정보 수정 (수정 기능)
    @RequestMapping(value = "/mypage/update", method = RequestMethod.POST)
    public String updateMyInfo(MemberDto update) throws Exception{
        cinemaService.updateMyInfo(update);
        return "redirect:/mypage/update";
    }

    // (DB 적용)
    // 회원 탈퇴 (뷰)
    // 마이페이지 내 프로필에서 회원 탈퇴를 누르면 뷰를 만들어서 보여준다.
    @RequestMapping(value = "/mypage/delete", method = RequestMethod.GET)
    public ModelAndView deleteProfile(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        ModelAndView mv = new ModelAndView("mypage/profile_delete");
        MemberDto myInfo = mypageService.selectMyInfo(loggedInUserId);
        mv.addObject("myInfo", myInfo);

        return mv;
    }

//    2022-12-15 양민호
//    (ajax + DB 적용) 탈퇴 페이지 비밀번호 확인 기능.
    @ResponseBody
    @RequestMapping(value = "/mypage/delete/checkPwd", method = RequestMethod.POST)
    public Object ajaxCalResult(@RequestParam("myid") String myid, @RequestParam("inputpwd") String inputpwd) throws Exception {
        int chkPwd = cinemaService.checkPwd(myid, inputpwd);
        return chkPwd;
    }

    // (DB 적용)
    // 2022-12-17 MoonNight285
    // 회원 탈퇴 (기능) 추후 경로 mypage로 변경 필요(작업됨)
    // 탈퇴후 메인으로 부모창이 이동해야하는데 아직 미적용
    @ResponseBody
    @RequestMapping(value = "/mypage/out", method = RequestMethod.DELETE)
    public String deleteAccount(MemberDto delete, HttpServletRequest request) throws Exception{
        cinemaService.deleteAccount(delete);

        HttpSession session = request.getSession();
        session.removeAttribute("loggedInUserInfo");
        session.invalidate();

        return "UserDeleted";
    }


//    결제 취소
    @RequestMapping(value = "/mypage/paycancle", method = RequestMethod.GET)
    public ModelAndView cancelPay() throws Exception {
        ModelAndView mv = new ModelAndView("mypage/payment_cancel");
        return mv;
    }

//    (DB 적용)
//    2022-12-15 양민호
//    book 페이지에서 입력값을 받아오는 좌석 선택 페이지 뷰
//    현재 book 페이지에 date 와 time값을 제외하고 임의의 고정된 값 받아오고 있음.
    @RequestMapping(value = "/seat" , method = RequestMethod.POST)
    public ModelAndView openSeat(@RequestParam("movieTitle") String title, @RequestParam("cinemaName") String cinemaName, @RequestParam("date") String date,
                                @RequestParam("screenHallName") String screenHallName, @RequestParam("time") String time) throws Exception {
        ModelAndView mv = new ModelAndView("movieseat");

        ScreenHallDto screenData = cinemaService.selectScreenData(title, cinemaName, screenHallName);


        String times = time;
        String dates = date;


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
        mv.addObject("times", times);
        mv.addObject("dates", dates);
        mv.addObject("screenData", screenData);
        return mv;
    }
}
