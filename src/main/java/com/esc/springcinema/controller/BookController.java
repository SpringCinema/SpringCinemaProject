package com.esc.springcinema.controller;

import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang

    @Autowired
    private CinemaService cinemaService;

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
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : EblynCho
    @RequestMapping("/payment")
    public String viewPayment() {
        return "payment";
    }


//    @ResponseBody
//    @RequestMapping(value = "/paymentInfo")
//    public String ajaxTest(@RequestBody HashMap<String, String> map) throws Exception {
////        HashMap<String, String> paymentInfo = new HashMap<>();
////        paymentInfo.put("title", map.get("title"));
//        map.put("title", map.get("title"));
//        return null;
//    }


}