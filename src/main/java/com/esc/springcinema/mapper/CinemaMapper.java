package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMapper {

    MemberDto selectMyInfo(String id) throws Exception;

    void updateMyInfo(MemberDto update) throws Exception;

    void deleteAccount(MemberDto delete) throws Exception;

    int checkPwd(String pwd) throws Exception;
}
