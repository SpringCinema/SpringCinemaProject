package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;

import java.util.List;

public interface CinemaService {
// 최종 수정 : 2022-12-15
// 마지막 작성자 : yang
// ----- 부터 ------
    public MemberDto selectMyInfo(String id) throws Exception;

    void updateMyInfo(MemberDto update) throws Exception;

    void deleteAccount(MemberDto delete) throws Exception;

    int checkPwd(String id, String pwd) throws Exception;

    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception;

    List<ScreenHallDto> allScreenTitle() throws Exception;
//    ---- 까지 ----
}
