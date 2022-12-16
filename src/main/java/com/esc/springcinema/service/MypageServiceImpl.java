package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
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
}
