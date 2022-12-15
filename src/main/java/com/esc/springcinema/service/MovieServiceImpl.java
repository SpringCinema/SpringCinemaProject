package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.SearchDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final String SERVICE_KEY = "3922EP8PL7QCSBYQ4DR8";
    private String strUrl;
    
    @Autowired
    CinemaMapper cinemaMapper;

    @Override
    // 서버가 처음으로 가동될때 또는 일정 시간이 지나고 데이터를 갱신할때 사용
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    public void init() throws Exception {
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        endDate.add(GregorianCalendar.MONTH, 1);

        for (int i = 0; i < 12; ++i) {
            System.out.println(sdf.format(startDate.getTime()));

            // 발매일 기준일은 당일기준 한달 전
            strUrl = "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?" +
                    "collection=kmdb_new2&detail=Y&listCount=100&" +
                    "releaseDts=" + sdf.format(startDate.getTime()) +
                    "&releaseDte=" + sdf.format(endDate.getTime()) +
                    "&ServiceKey=" + SERVICE_KEY;

            insertMovieInfo();
            startDate.add(GregorianCalendar.MONTH, -1); // 한달전으로
            endDate.add(GregorianCalendar.MONTH, -1); // 한달전으로
        }
    }

    // API로부터 영화 데이터 가져와서 반환
    // 미완성, 변수로 검색해야함
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    private List<MovieDto> getMovieDatas(String strUrl) throws Exception {
        SearchDto searchDto = new SearchDto();
        URL url = null;
        HttpURLConnection urlConn = null;
        List<MovieDto> movies = null;
        
        try {
            url = new URL(strUrl);
            urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setRequestMethod("GET");
        
            JAXBContext jc = JAXBContext.newInstance(SearchDto.class);
            Unmarshaller um = jc.createUnmarshaller();
            SearchDto fullData = (SearchDto)um.unmarshal(url);
            movies = fullData.getResult().getMovies();
        } catch (Exception e) {
            e.printStackTrace();
            if (urlConn != null) { urlConn.disconnect(); }
        }
    
        return movies;
    }
    
    // 영화정보를 API를 통해 받아서 DB에 저장
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : MoonNight285
    private void insertMovieInfo() throws Exception {
        List<MovieDto> movies = getMovieDatas(strUrl);
        for (int i = 0; i < movies.size(); ++i) {
            String docid = movies.get(i).getDocid();

            // DB에 동일한 영화의 아이디가 없어야 저장을 진행..
            if (cinemaMapper.selectMovieDocid(docid) == 0) {
                cinemaMapper.insertMovieDatas(movies.get(i));
                cinemaMapper.insertDirectors(movies.get(i));
                cinemaMapper.insertActors(movies.get(i));
            } else {
                System.out.println(docid);
            }
        }
    }
}
