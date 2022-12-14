package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
    
    // 유저아이디 체크
    public boolean isUserId(String targetId) throws Exception;
    
    // 로그인
    public boolean login(String targetId, String pwd) throws Exception;
    
    // 신규 유저 생성
    public boolean createMember(MemberDto member) throws Exception;
 }
