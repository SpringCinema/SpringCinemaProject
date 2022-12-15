package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.ResultDto;

import java.util.List;

public interface MovieService {
    
    // 영화정보를 가져와서 DB에 저장
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    public void insertMovieInfo() throws Exception;
}
