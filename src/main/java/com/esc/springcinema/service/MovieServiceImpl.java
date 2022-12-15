package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.MovieDto;
import com.esc.springcinema.dto.apiMovieDto.PlotDto;
import com.esc.springcinema.dto.apiMovieDto.SearchDto;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final String SERVICE_KEY = "3922EP8PL7QCSBYQ4DR8";
    private String releaseDts;
    private String title;
    
    @Autowired
    CinemaMapper cinemaMapper;
    
    public MovieServiceImpl() throws Exception {
        this("컨저링", "20000601");
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
    private List<MovieDto> getMovieDatas() throws Exception {
//        String strUrl = "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?collection=kmdb_new2&detail=Y" +
//                "&title=" + title + "&releaseDts=" + releaseDts + "&ServiceKey=" + SERVICE_KEY;
        String strUrl = "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?collection=kmdb_new2&detail=Y&releaseDts=20220101&listCount=100&ServiceKey=3922EP8PL7QCSBYQ4DR8";
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
    public void insertMovieInfo() throws Exception {
        List<MovieDto> movies = getMovieDatas();
        insertMovieData(movies);
    }
    
    private void insertMovieData(List<MovieDto> movies) throws Exception {
        for (int i = 0; i < movies.size(); ++i) {
            cinemaMapper.insertMovieDatas(movies.get(i));
        }
    }


    // 영화 검색
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public List<MovieDto> selectMoviesList() throws Exception {
        return cinemaMapper.selectMoviesList();
    }

    // 메인화면 캐러셀에 현재상영작 불러오기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public List<MovieDto> selectNowplayingMoviesList() throws Exception {
        return cinemaMapper.selectNowplayingMoviesList();
    }

    // 영화 상세보기
    // 최종 수정 : 2022-12-15
    // 마지막 작성자 : eblyncho
    @Override
    public MovieDto selectMovieDetail(String docid) throws Exception {
        return cinemaMapper.selectMovieDetail(docid);
    }

    @Override
    public PlotDto selectPlotText(String docid) throws Exception {
        return cinemaMapper.selectPlotText(docid);
    }
}
