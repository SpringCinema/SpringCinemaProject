package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;

import java.util.List;
import java.util.Map;

public interface MypageService {
    // 마이페이지 영화 예약목록 조회
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    public List<BooksDto> selectBookList(String userId, String state) throws Exception;
    
    // DB에서 마이페이지의 나의 정보를 조회하는 기능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    MemberDto selectMyInfo(String id) throws Exception;

    // DB에서 마이페이지의 나의 결제 내역을 조회하는 기능
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    List<PaymentsDto> selectMyPayment(String id, String state) throws Exception;

    // 마이페이지에서 유저정보 수정
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    void updateMyInfo(MemberDto update) throws Exception;

    // 마이페이지에서 탈퇴전 비밀번호 확인
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    int checkPwd(String id, String pwd) throws Exception;

    // 마이페이지에서 유저 탈퇴
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    void deleteAccount(MemberDto delete) throws Exception;
    
    // 마이페이지에서 결제취소 누르면 필요한 데이터 조회
    // 최종 수정 : 2022-12-19
    // 마지막 작성자 : MoonNight285
    Map<String, String> selectCancelMovieInfo(String bookNum, String id) throws Exception;
}
