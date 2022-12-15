package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.ResultDto;
import com.esc.springcinema.dto.apiMovieDto.SearchDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final String SERVICE_KEY = "3922EP8PL7QCSBYQ4DR8";
    private String releaseDts;
    private String title;
    
    @Autowired
    CinemaMapper cinemaMapper;
    
    public MovieServiceImpl() throws Exception {
        this("아바타", "20000601");
    }
    
    public MovieServiceImpl(String title, String releaseDts) throws Exception {
        this.title = URLEncoder.encode(title, "UTF-8");
        this.releaseDts = releaseDts;
    }
    
    public String getReleaseDts() {
        return releaseDts;
    }
    
    public void setReleaseDts(String releaseDts) {
        this.releaseDts = releaseDts;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    // API로부터 영화 데이터 가져와서 반환
    public List<MovieDto> getMovieDatas() throws Exception {
        title = URLEncoder.encode("아바타", "UTF-8");
        String strUrl = "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?collection=kmdb_new2&detail=Y" +
                "&title=" + title + "&releaseDts=" + releaseDts + "&ServiceKey=" + SERVICE_KEY;
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
    
    
    @Override
    public void insertMovieData(MovieDto Movies) throws Exception {
    
    }
}
