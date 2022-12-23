package com.esc.springcinema.service;

import com.esc.springcinema.dto.MovieUrlDto;
import com.esc.springcinema.dto.apiMovieDto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface MovieService {
    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectMoviesList() throws Exception;

    // 메인화면_현재상영작 캐러셀
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectNowplayingMoviesList() throws Exception;

    // 영화 상세페이지_영화 정보
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : eblyncho
    MovieDto selectMovieDetail(String docid) throws Exception;
    PlotDto selectPlotText(String docid) throws Exception;
    DirectorDto selectDirector(String docid) throws Exception;
    List<ActorDto> selectActor(String docid) throws Exception;


    // 서버가 처음으로 가동될때 또는 일정 시간이 지나고 데이터를 갱신할때 사용
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    public void init() throws Exception;
    
    // 서버가 시작됬거나 갱신시간이 됬을때만 장르목록을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    Set<String> selectGenre() throws Exception;
    
    // 장르목록를 선택해서 조건에 일치하는 영화들을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    HashMap<String, MovieDto> selectRecommendMoviesList(String genre) throws Exception;
    
    // 관람등급을 기준으로 영화를 검색해서 조건에 일치하는 영화들을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    HashMap<String, MovieDto> selectBirthMovieList(String id) throws Exception;

    // 상영예정작 목록
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : EblynCho
    List<MovieDto> selectUpcomingMoviesList() throws Exception;

    MovieUrlDto trailer(String docid) throws Exception;
}
