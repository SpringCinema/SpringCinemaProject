package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.MoviesDto;
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

    // 마이페이지 정보 출력
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    MemberDto selectMyInfo(String id) throws Exception;

    // 내 정보 수정 
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    void updateMyInfo(MemberDto update) throws Exception;

    // 회원탈퇴 
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    void deleteAccount(MemberDto delete) throws Exception;

    // 회원탈퇴 시 아이디 패스워드 확인
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    int checkPwd(String id, String pwd) throws Exception;

    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MoviesDto> selectMoviesList() throws Exception;

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    List<MoviesDto> selectNowplayingMoviesList() throws Exception;

    // 예매페이지의 선택정보 좌석 선택 페이지에 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : yang
    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName) throws Exception;

    // 예매페이지의 선택정보 좌석 선택 페이지에 불러오기
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : yang
    List<ScreenHallDto> allScreenTitle() throws Exception;
}
