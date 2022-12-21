package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;

import java.util.List;
import java.util.Set;

public interface CinemaService {
    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception;

    List<MovieDto> allScreenTitle() throws Exception;
//    ---- 까지 ----

    List<ScreenHallDto> selectMovieTime(String movieTitle, String cinemaName) throws Exception;

    List<ScreenHallDto> selectCinemaName(String title) throws Exception;

    int countBook(String title, String cinemaName, String screenHallName, String viewTime) throws Exception;

    MovieDto selectMoviePoster(String docid) throws Exception;
}
