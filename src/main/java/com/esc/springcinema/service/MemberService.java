package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
    
    // 유저아이디 체크
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    public boolean isUserId(String targetId) throws Exception;
    
    // 로그인
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    public MemberDto login(String targetId, String pwd) throws Exception;
    
    // 신규 유저 생성
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    public boolean createMember(MemberDto member) throws Exception;
}
