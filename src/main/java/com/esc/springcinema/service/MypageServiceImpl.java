package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.mapper.CinemaMapper;
import com.esc.springcinema.mapper.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageServiceImpl implements MypageService {
    @Autowired
    private MypageMapper mypageMapper;
    
    // 마이페이지 영화 예약목록 조회
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @Override
    public List<BooksDto> selectBookList(String userId, String state) throws Exception {
        return mypageMapper.selectBookList(userId, state);
    }
    
    // DB에서 마이페이지의 나의 정보를 조회하는 기능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @Override
    public MemberDto selectMyInfo(String id) throws Exception {
        return mypageMapper.selectMyInfo(id);
    }

    // DB에서 마이페이지의 나의 결제 내역을 조회하는 기능
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @Override
    public List<PaymentsDto> selectMyPayment(String id, String state) throws Exception {
        return mypageMapper.selectMyPayment(id, state);
    }

    // 마이페이지에서 유저정보 수정
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    public void updateMyInfo(MemberDto update) throws Exception {
        mypageMapper.updateMyInfo(update);
    }

    // 마이페이지에서 탈퇴전 비밀번호 확인
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @Override
    public int checkPwd(String id, String pwd) throws Exception {
        return mypageMapper.checkPwd(id, pwd);
    }

    // 마이페이지에서 유저 탈퇴
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @Override
    public void deleteAccount(MemberDto delete) throws Exception {
        mypageMapper.deleteAccount(delete);
    }
}
