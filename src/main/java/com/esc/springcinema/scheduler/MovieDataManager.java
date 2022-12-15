package com.esc.springcinema.scheduler;

import com.esc.springcinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Controller
public class MovieDataManager {
    @Autowired
    private MovieService movieService;
    
    @Scheduled(cron = "0 0 3 * * *")
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }
    
    @RequestMapping("/test")
    private String getMovieDatas() throws Exception {
        movieService.init();
        return "";
    }
}
