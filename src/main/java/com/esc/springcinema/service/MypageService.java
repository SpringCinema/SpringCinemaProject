package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;

import java.util.List;

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
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    PaymentsDto selectMyPayment(String id) throws Exception;
}
