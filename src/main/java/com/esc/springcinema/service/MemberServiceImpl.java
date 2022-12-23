package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private CinemaMapper cinemaMapper;
    
    // 아이디가 이미 존재할시 개수가 1이 반환 존재안하면 0이 반환
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @Override
    public boolean isUserId(String targetId) throws Exception {
        return cinemaMapper.isUserId(targetId) == 1 ? true : false;
    }
    
    // 로그인시 전달받은 아이디를 검증해서 로그인 여부를 결정
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @Override
    public MemberDto login(String targetId, String pwd) throws Exception {
        MemberDto member = cinemaMapper.login(targetId, pwd);
        if (member == null) {
            return null;
        } else {
            return member;
        }
    }
    
    // 회원가입 처리
    // 검증과정은 추후에 처리
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    @Override
    public boolean createMember(MemberDto member) throws Exception {
        cinemaMapper.createMember(member);
        
        return true; // 임시로 무조건 true
    }

    // 비밀번호 찾기 아이디 이메일 확인
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @Override
    public int checkIdEmail(String id, String email) throws Exception {
        return cinemaMapper.checkIdEmail(id, email);
    }

    // 비밀번호 변경
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    @Override
    public void pwdUpdate(String pwd, String id) throws Exception {
        cinemaMapper.pwdUpdate(pwd, id);
    }
    
    // 현재 사용자가 로그인 되어있다면 로그인한 아이디를 반환한다.
    // 최종 수정 : 2022-12-22
    // 마지막 작성자 : MoonNight285
    @Override
    public String getLoggedInUserId(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        if (session.getAttribute("loggedInUserInfo") != null) {
            session.setMaxInactiveInterval(1800);
            return ((MemberDto)session.getAttribute("loggedInUserInfo")).getId();
        } else {
            return "";
        }
    }
    
}
