package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
    // DB에서 마이페이지의 예약 목록을 조회하는 기능
    // state에 상태값 선택가능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    List<BooksDto> selectBookList(String userId, String state) throws Exception;
}
