package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMapper {
    
    // 일치하는 아이디의 개수를 반환한다.
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    int isUserId(String targetId) throws Exception;
    
    // 일치하는 유저의 개수를 반환한다.
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    int login(String targetId, String pwd) throws Exception;
    
    // 신규 유저 생성
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    void createMember(MemberDto member) throws Exception;
}
