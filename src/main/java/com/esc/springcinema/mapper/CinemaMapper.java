package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMapper {
    
    // 일치하는 아이디의 개수를 반환한다.
    int isUserId(String targetId) throws Exception;
    
    // 일치하는 유저의 개수를 반환한다.
    int login(String targetId, String pwd) throws Exception;
    
    // 신규유저 생성
    void createMember(MemberDto member) throws Exception;
}
