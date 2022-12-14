package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private CinemaMapper cinemaMapper;
    
    // 아이디가 이미 존재할시 개수가 1이 반환 존재안하면 0이 반환
    @Override
    public boolean isUserId(String targetId) throws Exception {
        return cinemaMapper.isUserId(targetId) == 1 ? true : false;
    }
    
    // 로그인시 일치하는 유저의 아이디의 개수가 1이면 성공 아니면 실패
    @Override
    public boolean login(String targetId, String pwd) throws Exception {
        return cinemaMapper.login(targetId, pwd) == 1 ? true : false;
    }
    
    // 회원가입 처리
    // 검증과정은 추후에 처리
    @Override
    public boolean createMember(MemberDto member) throws Exception {
        cinemaMapper.createMember(member);
        
        return true; // 임시로 무조건 true
    }
}
