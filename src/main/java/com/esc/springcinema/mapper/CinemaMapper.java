package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;

import com.esc.springcinema.dto.apiMovieDto.ActorDto;
import com.esc.springcinema.dto.apiMovieDto.DirectorDto;
import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.PlotDto;

import com.esc.springcinema.dto.ScreenHallDto;

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

    // 영화 상세페이지_영화 정보 리턴
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : eblyncho
    MovieDto selectMovieDetail(String docid) throws Exception;
    PlotDto selectPlotText(String docid) throws Exception;
    DirectorDto selectDirector(String docid) throws Exception;
    List<ActorDto> selectActor(String docid) throws Exception;

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


    // 예매페이지의 선택정보 좌석 선택 페이지에 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception;

    // 예매페이지의 선택정보 좌석 선택 페이지에 불러오기
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    List<MovieDto> allScreenTitle() throws Exception;

    // 예매페이지의 극장 이름 불러오기
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    List<ScreenHallDto> selectCinemaName(String title) throws Exception;

    // 예매페이지의 선택한 영화/극장의 상영 시간 불러오기
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    List<ScreenHallDto> selectMovieTime(String movieTitle, String cinemaName) throws Exception;

    // 영화 상영 날짜에 예약된 좌석 수 불러오기
    // 최종 수정 : 2022-12-19
    // 마지막 작성자 : yang
    int countBook(String title, String cinemaName, String screenHallName, String viewTime) throws Exception;

    // 서버가 시작됬거나 갱신시간이 됬을때만 장르목록을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    List<String> selectGenre() throws Exception;
    
    // 장르목록를 선택해서 조건에 일치하는 영화들을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    List<MovieDto> selectRecommendMoviesList(String genre) throws Exception;
    
    // 관람등급을 기준으로 영화를 검색해서 조건에 일치하는 영화들을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    List<MovieDto> selectBirthMovieList(List<String> movieRanks) throws Exception;
    
    // 선택한 유저의 생년을 조회한다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    int selectUserBirth(String id) throws Exception;

    // 선택한 영화가 현재 상영중인지를 확인한다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    List<String> selectViewAbleMovie(List<String> movies) throws Exception;

    // 비밀번호 찾기 아이디 이메일 확인
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    int checkIdEmail(String id, String email) throws Exception;

    // 비밀번호 변경
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : yang
    void pwdUpdate(String pwd, String id) throws Exception;
}
