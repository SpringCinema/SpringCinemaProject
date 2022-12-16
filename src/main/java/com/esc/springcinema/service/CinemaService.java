package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;

import java.util.List;

public interface CinemaService {
    void updateMyInfo(MemberDto update) throws Exception;

    void deleteAccount(MemberDto delete) throws Exception;

    int checkPwd(String id, String pwd) throws Exception;

    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName);
}
