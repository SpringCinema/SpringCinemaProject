package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.*;

import java.util.List;

public interface MovieService {
    public void insertMovieInfo() throws Exception;

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectMoviesList() throws Exception;

    // 메인화면_현재상영작 캐러셀
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectNowplayingMoviesList() throws Exception;

    // 영화 상세보기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    MovieDto selectMovieDetail(String docid) throws Exception;

    PlotDto selectPlotText(String docid) throws Exception;

    DirectorDto selectDirector(String docid) throws Exception;

    List<ActorDto> selectActor(String docid) throws Exception;
}
