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
    @Autowired
    private MovieService movieService;

    // 새벽3시에 한번씩 영화목록을 업데이트 해준다.
    // 작성일 : 2022-12-15
    // 작성자 : MoonNight285
    @Scheduled(cron = "0 0 3 * * *")
    public void updateMovieInfo() throws Exception {
        movieService.init();
    }

    // 테스트용도
    // 작성일 : 2022-12-16
    // 작성자 : MoonNight285
    @RequestMapping(value = "movieInfo", method = RequestMethod.GET)
    private String getMovieDatas() throws Exception {
        movieService.init();
        return "";
    }
}
