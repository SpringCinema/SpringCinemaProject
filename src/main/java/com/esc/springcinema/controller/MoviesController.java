package com.esc.springcinema.controller;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.MovieUrlDto;
import com.esc.springcinema.dto.apiMovieDto.ActorDto;
import com.esc.springcinema.dto.apiMovieDto.DirectorDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.PlotDto;
import com.esc.springcinema.scheduler.MovieDataManager;
import com.esc.springcinema.service.MemberService;
import com.esc.springcinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MoviesController {

    @Autowired
    private MovieService movieService;
    
    @Autowired
    private MovieDataManager movieDataManager;
    
    @Autowired
    private MemberService memberService;

    // 메인화면 캐러셀에 현재상영작, 추천목록 불러오기
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/main")
    public ModelAndView viewNowplayingMoviesList(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";

        HashMap<String, MovieDto> birthList = new HashMap<>(); // 값이 없는경우 사이즈는 0
        if (userId.equals("") == false) {
            birthList = movieService.selectBirthMovieList(userId);
            isLogin = "true";
        }
        
        ModelAndView mv = new ModelAndView("main");
        
        String randomGenre = movieDataManager.getRandomGenre();
        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        HashMap<String, MovieDto> recommendList = movieService.selectRecommendMoviesList(randomGenre);
        
        mv.addObject("nowplayingList", nowplayingList);
        mv.addObject("recommendList", recommendList);
        mv.addObject("randomGenre", randomGenre);
        mv.addObject("birthList", birthList);
        mv.addObject("isLogin", isLogin);

        return mv;
    }

    // 영화 검색
    // 최종 수정 : 2022-12-26
    // 마지막 작성자 : EblynCho
    @ResponseBody
    @RequestMapping(value = "/searchMovie")
    public ModelAndView viewMoviesList(String keyword) throws Exception {
        ModelAndView mv = new ModelAndView("search");

        List<MovieDto> dataList = movieService.searchMoviesList(keyword);
//        System.out.println(keyword);
        mv.addObject("dataList", dataList);

        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);

        return mv;
    }


    // 영화_현재상영작 페이지
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/nowplaying")
    public ModelAndView viewNowPlaying(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";

        if (userId.equals("") == false) {
            isLogin = "true";
        }

        ModelAndView mv = new ModelAndView("nowplaying");

        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);
        mv.addObject("isLogin", isLogin);

        return mv;
    }

    // 영화_상영예정작 페이지
    // 최종 수정 : 2022-12-23
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/upcoming")
    public ModelAndView viewUpcoming(HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";
    
        if (userId.equals("") == false) {
            isLogin = "true";
        }
        
        ModelAndView mv = new ModelAndView("upcoming");

        List<MovieDto> upcomingList = movieService.selectUpcomingMoviesList();
        mv.addObject("upcomingList", upcomingList);
        mv.addObject("isLogin", isLogin);

        return mv;
    }

    // 영화_상세 페이지
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    @RequestMapping("/movieDetail")
    public ModelAndView openMovieDetail(@RequestParam String docid, HttpServletRequest request) throws Exception {
        String userId = memberService.getLoggedInUserId(request);
        String isLogin = "false";

        if (userId.equals("") == false) {
            isLogin = "true";
        }

        ModelAndView mv = new ModelAndView("movieDetail");

        MovieDto movies = movieService.selectMovieDetail(docid);
        mv.addObject("movies", movies);

        PlotDto plotText = movieService.selectPlotText(docid);
        mv.addObject("plotText", plotText);

        DirectorDto director = movieService.selectDirector(docid);
        mv.addObject("director", director);

        List<ActorDto> actorList = movieService.selectActor(docid);
        mv.addObject("actorList", actorList);

        mv.addObject("docId",docid);

        mv.addObject("isLogin", isLogin);

        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);

        MovieUrlDto url = movieService.trailer(docid);
        mv.addObject("url", url);

        return mv;
    }
}