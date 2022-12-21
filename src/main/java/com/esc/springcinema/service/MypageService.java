package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.github.pagehelper.Page;

import java.util.Map;

public interface MypageService {
    // 마이페이지 영화 예약목록 조회
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    public Page<BooksDto> selectBookList(String userId, String state, int pageNo) throws Exception;
    
    // DB에서 마이페이지의 나의 정보를 조회하는 기능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    MemberDto selectMyInfo(String id) throws Exception;

    // DB에서 마이페이지의 나의 결제 내역을 조회하는 기능
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    Page<PaymentsDto> selectMyPayment(String id, String state, int pageNo) throws Exception;

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
    
    // 결제취소정보에 표시될 포스터를 조회하기 위한기능
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    String selectMovieFirstPoster(String title) throws Exception;
    
    // 결제한 영화를 취소하는 기능
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    void callCancelPayment(String paymentNum, String bookNum) throws Exception;
}
