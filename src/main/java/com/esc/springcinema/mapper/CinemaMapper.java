package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.PlotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CinemaMapper {
    
    // 일치하는 아이디의 개수를 반환한다.
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    int isUserId(String targetId) throws Exception;
    
    // 일치하는 유저의 정보를 반환(아이디, 이름만 포함)
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    MemberDto login(String targetId, String pwd) throws Exception;
    
    // 신규 유저 생성
    // 최종 수정 : 2022-12-14
    // 마지막 작성자 : MoonNight285
    void createMember(MemberDto member) throws Exception;

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectMoviesList() throws Exception;

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MovieDto> selectNowplayingMoviesList() throws Exception;

    // 영화 상세보기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    MovieDto selectMovieDetail(String docid) throws Exception;

    PlotDto selectPlotText(String docid) throws Exception;

    // API를 통해 가져온 영화 데이터를 저장
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    void insertMovieDatas(MovieDto movie) throws Exception;
    
    // API를 통해 가져온 디렉터를 저장
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    void insertDirectors(MovieDto movie) throws Exception;
    
    // API를 통해 가져온 배우를 저장
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    void insertActors(MovieDto movie) throws Exception;

    // 영화의 아이디가 존재하는지 확인하는 함수
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    int selectMovieDocid(String docid) throws Exception;
}
