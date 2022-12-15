package com.esc.springcinema.controller;

import com.esc.springcinema.dto.MoviesDto;
import com.esc.springcinema.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/main")
    public ModelAndView viewNowplayingMoviesList() throws Exception {
        ModelAndView mv = new ModelAndView("main");

        List<MoviesDto> nowplayingList = moviesService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);

        return mv;
    }

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/searchMovie")
    public ModelAndView viewMoviesList() throws Exception {
        ModelAndView mv = new ModelAndView("search");

        List<MoviesDto> dataList = moviesService.selectMoviesList();
        mv.addObject("dataList", dataList);

        return mv;
    }
}
