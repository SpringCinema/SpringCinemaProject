package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService{
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public MemberDto selectMyInfo(String id) throws Exception {
        return cinemaMapper.selectMyInfo(id);
    }

    @Override
    public void updateMyInfo(MemberDto update) throws Exception {
        cinemaMapper.updateMyInfo(update);
    }

    @Override
    public void deleteAccount(MemberDto delete) throws Exception {
        cinemaMapper.deleteAccount(delete);
    }

    @Override
    public int checkPwd(String id, String pwd) throws Exception {
        return cinemaMapper.checkPwd(id, pwd);
    }

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


}
