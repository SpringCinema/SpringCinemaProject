package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
    // DB에서 마이페이지의 예약 목록을 조회하는 기능
    // state에 상태값 선택가능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    List<BooksDto> selectBookList(String id, String state) throws Exception;
    
    // DB에서 마이페이지의 나의 정보를 조회하는 기능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    MemberDto selectMyInfo(String id) throws Exception;

    // DB에서 마이페이지의 나의 결제 내역을 조회하는 기능
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    PaymentsDto selectMyPayment(String id, String state) throws Exception;

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
}
