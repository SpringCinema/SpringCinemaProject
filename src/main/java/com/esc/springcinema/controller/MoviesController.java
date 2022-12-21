package com.esc.springcinema.controller;

import com.esc.springcinema.dto.apiMovieDto.ActorDto;
import com.esc.springcinema.dto.apiMovieDto.DirectorDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.PlotDto;
import com.esc.springcinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    private MovieService movieService;

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/main")
    public ModelAndView viewNowplayingMoviesList() throws Exception {
        ModelAndView mv = new ModelAndView("main");

        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);

        return mv;
    }

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/searchMovie")
    public ModelAndView viewMoviesList() throws Exception {
        ModelAndView mv = new ModelAndView("search");

        List<MovieDto> dataList = movieService.selectMoviesList();
        mv.addObject("dataList", dataList);

        return mv;
    }

    // 영화_현재상영작 페이지
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : EblynCho
    @RequestMapping("/nowplaying")
    public ModelAndView viewNowPlaying() throws Exception {
        ModelAndView mv = new ModelAndView("nowplaying");

        List<MovieDto> nowplayingList = movieService.selectNowplayingMoviesList();
        mv.addObject("nowplayingList", nowplayingList);

        return mv;
    }

    // 영화_상영예정작 페이지
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/upcoming")
    public String viewUpcoming() throws Exception {
        return "upcoming";
    }

    // 영화_상세 페이지
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @RequestMapping("/movieDetail")
    public ModelAndView openMovieDetail(@RequestParam String docid) throws Exception {
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

        return mv;
    }
}