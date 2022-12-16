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
    public ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) {
        return cinemaMapper.selectScreenData(movieTitle, cinemaName, screenHallName);
    }


}
