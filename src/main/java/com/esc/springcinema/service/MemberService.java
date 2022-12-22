package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    // 비밀번호 찾기 아이디 이메일 확인
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    int checkIdEmail(String id, String email) throws Exception;

    // 비밀번호 변경
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    void pwdUpdate(String pwd, String id) throws Exception;
    
    // 현재 사용자가 로그인 되어있다면 로그인한 아이디를 반환한다.
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    public String getLoggedInUserId(HttpServletRequest request) throws Exception;
}
