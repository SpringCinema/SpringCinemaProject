package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService{
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) {
        return cinemaMapper.selectScreenData(movieTitle, cinemaName, screenHallName);
    }


}
