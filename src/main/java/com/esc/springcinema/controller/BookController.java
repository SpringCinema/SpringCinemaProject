package com.esc.springcinema.controller;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.service.CinemaService;
import com.esc.springcinema.service.MypageService;
import com.esc.springcinema.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private MypageService mypageService;

    // 예약 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    @RequestMapping("/book")
    public ModelAndView viewBook(@RequestParam(value = "docid", required = false) String docid) throws Exception{
        ModelAndView mv = new ModelAndView("book_test_DB");
        List<MovieDto> allScreenTitle = cinemaService.allScreenTitle();
        mv.addObject("allScreenTitle", allScreenTitle);
        mv.addObject("docId", docid);
        return mv;
    }

    // 예매 페이지에서 선택된 영화의 극장을 가져오는 부분
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : yang
    @ResponseBody
    @RequestMapping(value = "/book/cinema", method = RequestMethod.POST)
    public Object ajaxCinemaName(@RequestParam("movieTitle") String title) throws Exception{
        List<ScreenHallDto> cinemaName = cinemaService.selectCinemaName(title);

        return cinemaName;
    }

    // 예매 페이지에서 선택된 영화의 상영시간을 가져오는 부분
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    @ResponseBody
    @RequestMapping(value = "/book/viewTime", method = RequestMethod.POST)
    public Object ajaxViewTime(@RequestParam("movieTitle") String title, @RequestParam("cinemaName") String cinemaName) throws Exception{
        List<ScreenHallDto> selectMovieTime = cinemaService.selectMovieTime(title, cinemaName);

        return selectMovieTime;
    }

    // 영화 상영 날짜에 예약된 좌석 수 가져오는 부분
    // 최종 수정 : 2022-12-19
    // 마지막 작성자 : yang
    @ResponseBody
    @RequestMapping(value = "/book/remainSeats", method = RequestMethod.POST)
    public Object ajaxBookSeat(@RequestParam("title") String title, @RequestParam("cinema") String cinemaName,
                               @RequestParam("hall") String screenHallName, @RequestParam("viewTime") String viewTime) throws Exception{
        int reservedSeat = cinemaService.countBook(title, cinemaName, screenHallName, viewTime);

        return reservedSeat;
    }

    // 결제 전 예매정보 확인 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : EblynCho
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView viewPayment(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        if (session.getAttribute("loggedInUserInfo") == null) {
            ModelAndView mv = new ModelAndView("/login");
            return mv;
        }

        session.setMaxInactiveInterval(1800);
        String loggedInUserId = ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        ModelAndView mv = new ModelAndView("/payment");
        MemberDto myInfo = mypageService.selectMyInfo(loggedInUserId);
        mv.addObject("myInfo", myInfo);

        return mv;
    }

    // 결제 후 예매 테이블에 정보 저장
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : EblynCho
    @ResponseBody
    @RequestMapping(value = "/paymentInfo", method = RequestMethod.POST)
    public String booking(@RequestBody BooksDto book) throws Exception {
        paymentService.booking(book);
        return null;
    }

    // 결제 후 결제 테이블에 정보 저장
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : EblynCho
    @ResponseBody
    @RequestMapping(value = "/billInfo", method = RequestMethod.POST)
    public String bill(@RequestBody PaymentsDto payment) throws Exception {
        paymentService.bill(payment);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/getBookSeat", method = RequestMethod.POST)
    public Object getBookSeat(@RequestParam("title") String title, @RequestParam("screenName") String screen, @RequestParam("screenTime") String time) throws Exception {
        int yIdx = time.indexOf("년");
        int mIdx = time.indexOf("월");
        int dIdx = time.indexOf("일");
        int viewIdx = time.indexOf("요일");
        String year = time.substring(0, yIdx);
        String month = time.substring(yIdx+2, mIdx);
        String dt = time.substring(mIdx+2, dIdx);
        String viewTime = time.substring(viewIdx+2);
        String vTime = year + "-" + month + "-" + dt + " " + viewTime;

        int screenIdx = screen.indexOf("점");
        String cinema = screen.substring(0, screenIdx+1);
        String screenHall = screen.substring(screenIdx+2);

        List<BooksDto> bookSeat = cinemaService.selectSeatCode(title, cinema, screenHall, vTime);
        System.out.println(bookSeat);

        return bookSeat;
    }
}