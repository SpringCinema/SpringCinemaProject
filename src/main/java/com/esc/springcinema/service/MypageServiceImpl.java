package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.mapper.MypageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MypageServiceImpl implements MypageService {
    @Autowired
    private MypageMapper mypageMapper;
    
    // 마이페이지 영화 예약목록 조회
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    @Override
    public Page<BooksDto> selectBookList(String userId, String state, int pageNo) throws Exception {
        // startPate => 첫번째 매개변수로 화면에 출력할 페이지, 두번째 매개변수로 화면에 출력할 컨텐츠의 수 설정
        PageHelper.startPage(pageNo, 12);
        return mypageMapper.selectBookList(userId, state);
    }
    
    // DB에서 마이페이지의 나의 정보를 조회하는 기능
    // 최종 수정 : 2022-12-16
    // 마지막 작성자 : MoonNight285
    @Override
    public MemberDto selectMyInfo(String id) throws Exception {
        return mypageMapper.selectMyInfo(id);
    }

    // DB에서 마이페이지의 나의 결제 내역을 조회하는 기능
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    @Override
    public Page<PaymentsDto> selectMyPayment(String id, String state, int pageNo) throws Exception {
        // startPate => 첫번째 매개변수로 화면에 출력할 페이지, 두번째 매개변수로 화면에 출력할 컨텐츠의 수 설정
        PageHelper.startPage(pageNo, 12);
        return mypageMapper.selectMyPayment(id, state);
    }

    // 마이페이지에서 유저정보 수정
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    public void updateMyInfo(MemberDto update) throws Exception {
        mypageMapper.updateMyInfo(update);
    }

    // 마이페이지에서 탈퇴전 비밀번호 확인
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @Override
    public int checkPwd(String id, String pwd) throws Exception {
        return mypageMapper.checkPwd(id, pwd);
    }

    // 마이페이지에서 유저 탈퇴
    // 최종 수정 : 2022-12-18
    // 마지막 작성자 : MoonNight285
    @Override
    public void deleteAccount(MemberDto delete) throws Exception {
        mypageMapper.deleteAccount(delete);
    }
    
    // 마이페이지에서 결제취소 누르면 필요한 데이터 조회
    // 최종 수정 : 2022-12-19
    // 마지막 작성자 : MoonNight285
    @Override
    public Map<String, String> selectCancelMovieInfo(String bookNum, String id) throws Exception {
        return mypageMapper.selectCancelMovieInfo(bookNum, id);
    }
    
    // 결제취소정보에 표시될 포스터를 조회하기 위한기능
    // 최종 수정 : 2022-12-20
    // 마지막 작성자 : MoonNight285
    @Override
    public String selectMovieFirstPoster(String title) throws Exception {
        String posters = mypageMapper.selectMovieFirstPoster(title); // 포스터가 여러개가 들어온다.

        if (posters != null && posters != "") {
            return posters.split("\\|")[0]; // 가장 첫번째 포스터를 반환한다.
        } else {
            return posters;
        }
    }
    
    // 결제한 영화를 취소하는 기능
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    @Override
    public void callCancelPayment(String paymentNum, String bookNum) throws Exception {
        mypageMapper.callCancelPayment(paymentNum, bookNum);
    }
}
