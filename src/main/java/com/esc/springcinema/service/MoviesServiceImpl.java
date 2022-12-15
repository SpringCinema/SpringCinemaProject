package com.esc.springcinema.service;

import com.esc.springcinema.dto.MoviesDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private CinemaMapper cinemaMapper;

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public List<MoviesDto> selectMoviesList() throws Exception {
        return cinemaMapper.selectMoviesList();
    }

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public List<MoviesDto> selectNowplayingMoviesList() throws Exception {
        return cinemaMapper.selectNowplayingMoviesList();
    }

    // 영화 상세보기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public MoviesDto selectMovieDetail(String docid) throws Exception {
        return cinemaMapper.selectMovieDetail(docid);
    }
}
