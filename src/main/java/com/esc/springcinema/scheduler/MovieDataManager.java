package com.esc.springcinema.scheduler;

import com.esc.springcinema.service.MovieService;
import com.esc.springcinema.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

// 나중에 컨트롤러 제거해야함
// 그리고 서버 켜질때 데이터 갱신해야함
@Component
@Controller
public class MovieDataManager {
    private boolean isFirstUpdate = true;
    @Autowired
    private MovieService movieService;

    // 새벽 4시에 한번씩 영화목록을 업데이트 해준다.
    // 마지막 작성일 : 2022-12-16
    // 작성자 : MoonNight285
    @Scheduled(cron = "0 0 4 * * *")
    public void updateMovieInfo() throws Exception {
        movieService.init();
    }
    
    // * 서버 가동할때마다 API 통신을 하기때문에 개발단계에서는 일부러 주석처리함 *
    // 서버키면 영화목록을 갱신을 안했다면 갱신시켜준다.
    // 반복시간은 1일로 설정되어있는데 일 하지말라고 일부러 1일로 설정함
    // 마지막 작성일 : 2022-12-16
    // 작성자 : MoonNight285
    // @Scheduled(fixedRate = 86400000)
    // public void bootServer() throws Exception {
    //    if (isFirstUpdate == true) {
    //        updateMovieInfo();
    //        isFirstUpdate = false;
    //    }
    //}

    // 테스트용도
    // 나중에 반드시 삭제할것
    // 작성일 : 2022-12-16
    // 작성자 : MoonNight285
    @RequestMapping(value = "movieInfo", method = RequestMethod.GET)
    private String getMovieDatas() throws Exception {
        movieService.init();
        return "";
    }
}
