package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;

import java.util.List;

public interface CinemaService {
    public MemberDto selectMyInfo(String id) throws Exception;

    void updateMyInfo(MemberDto update) throws Exception;

    void deleteAccount(MemberDto delete) throws Exception;

    int checkPwd(String pwd) throws Exception;
}
