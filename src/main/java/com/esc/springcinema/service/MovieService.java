package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.ResultDto;

import java.util.List;

public interface MovieService {
    public List<MovieDto> getMovieDatas() throws Exception;
    
    // 영화데이터 저장
    public void insertMovieData(MovieDto Movies) throws Exception;
}
