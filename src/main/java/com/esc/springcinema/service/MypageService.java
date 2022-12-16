package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;

import java.util.List;

public interface MypageService {
    // 마이페이지 영화 예약목록 조회
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    public List<BooksDto> selectBookList(String userId) throws Exception;
}
