package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception{
        return cinemaMapper.selectScreenData(movieTitle, cinemaName, screenHallName);
    }

    @Override
    public List<MovieDto> allScreenTitle() throws Exception {
        return cinemaMapper.allScreenTitle();
    }

    @Override
    public List<ScreenHallDto> selectMovieTime(String movieTitle, String cinemaName) throws Exception {
        return cinemaMapper.selectMovieTime(movieTitle, cinemaName);
    }

    @Override
    public List<ScreenHallDto> selectCinemaName(String title) throws Exception {
        return cinemaMapper.selectCinemaName(title);
    }

    @Override
    public int countBook(String title, String cinemaName, String screenHallName, String viewTime) throws Exception {
        return cinemaMapper.countBook(title, cinemaName, screenHallName, viewTime);
    }

    @Override
    public MovieDto selectMoviePoster(String docid) throws Exception {
        return cinemaMapper.selectMovieDetail(docid);
    }
    
    // 서버가 시작됬거나 갱신시간이 됬을때만 장르목록을 가져온다.
    // DB에서 저장된 장르목록은 여러개 존재하기때문에
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    @Override
    public Set<String> selectGenre() throws Exception {
        Set<String> genreSet = new HashSet<>();
        List<String> genreList = cinemaMapper.selectGenre();
        
        for (String genres : genreList) {
            String[] splitGenre = genres.split(","); // SF,드라마 이런식으로 붙어있기때문에 자르기 작업 수행
            
            for (String genre : splitGenre) {
                genreSet.add(genre); // 잘라서 나온 장르를 추가한다.
            }
        }
        
        return genreSet; // 최종적으로는 중복이 제거되고 남은 장르의 목록을 반환
    }
}
