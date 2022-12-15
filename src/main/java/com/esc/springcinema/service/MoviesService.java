package com.esc.springcinema.service;

import com.esc.springcinema.dto.MoviesDto;

import java.util.List;

public interface MoviesService {

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MoviesDto> selectMoviesList() throws Exception;

    // 메인화면_현재상영작 캐러셀
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MoviesDto> selectNowplayingMoviesList() throws Exception;

    // 영화 상세보기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    MoviesDto selectMovieDetail(String docid) throws Exception;
}
