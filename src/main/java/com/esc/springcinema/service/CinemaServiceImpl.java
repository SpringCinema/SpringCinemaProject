package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception{
        return cinemaMapper.selectScreenData(movieTitle, cinemaName, screenHallName);
    }

    @Override
    public List<MovieDto> allScreenTitle() throws Exception {
        return cinemaMapper.allScreenTitle();
    }

    @Override
    public List<ScreenHallDto> selectMovieTime(String movieTitle, String cinemaName) throws Exception {
        return cinemaMapper.selectMovieTime(movieTitle, cinemaName);
    }

    @Override
    public List<ScreenHallDto> selectCinemaName(String title) throws Exception {
        return cinemaMapper.selectCinemaName(title);
    }

    @Override
    public int countBook(String title, String cinemaName, String screenHallName, String viewTime) throws Exception {
        return cinemaMapper.countBook(title, cinemaName, screenHallName, viewTime);
    }

    @Override
    public MovieDto selectMoviePoster(String docid) throws Exception {
        return cinemaMapper.selectMovieDetail(docid);
    }

    @Override
    public List<BooksDto> selectSeatCode(String movieTitle, String cinemaName, String screenHallName, String vTime) throws Exception{
        return cinemaMapper.selectSeatCode(movieTitle, cinemaName, screenHallName, vTime);
    }
}
