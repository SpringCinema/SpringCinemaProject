package com.esc.springcinema.controller;

import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ModelAndView viewBook() throws Exception{
        ModelAndView mv = new ModelAndView("book_test_DB");
        List<MovieDto> allScreenTitle = cinemaService.allScreenTitle();
        mv.addObject("allScreenTitle", allScreenTitle);
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

    // 임시 결제 페이지를 보여줍니다.
    // 최종 수정 : 2022-12-12
    // 마지막 작성자 : MoonNight285
//    @RequestMapping("/payment")
//    public String viewPayment() {
//        return "payment";
//    }
//    @RequestMapping(value = "/paymentInfo")
//    public String viewPaymentInfo(@RequestParam Map<String, Object> param) throws Exception {
//        String title = (String) param.get("title");
//        return "payment";
//    }

    @RequestMapping(value = "/payment")
    public String viewPaymentInfo(@RequestParam Map<String, Object> param) {
//        ModelAndView mv = new ModelAndView("payment");
        String title = (String) param.get("title");
//        mv.addObject("title", title);
        return "payment";
    }

//    @RequestMapping(value = "/paymentInfo")
//    public Map<String, Object> viewPaymentInfo(@RequestParam Map<String, Object> param) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//
//        String title = (String) param.get("title");
//        map.put("title", title);
//
//        return map;
//    }

}
