package com.esc.springcinema.service;

import com.esc.springcinema.dto.apiMovieDto.*;
import com.esc.springcinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

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
            // 발매일 기준일은 당일기준 한달 전
            strUrl = "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?" +
                    "collection=kmdb_new2&detail=Y&listCount=100&" +
                    "releaseDts=" + sdf.format(startDate.getTime()) +
                    "&releaseDte=" + sdf.format(endDate.getTime()) +
                    "&type=" + URLEncoder.encode("극영화", "UTF-8") +
                    "&type=" + URLEncoder.encode("애니메이션", "UTF-8") +
                    "&ServiceKey=" + SERVICE_KEY;

            insertMovieInfo();
            startDate.add(GregorianCalendar.MONTH, -1); // 한달전으로
            endDate.add(GregorianCalendar.MONTH, -1); // 한달전으로
        }
    }

    // API로부터 영화 데이터 가져와서 반환
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
            }
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

    @Override
    public DirectorDto selectDirector(String docid) throws Exception {
        return cinemaMapper.selectDirector(docid);
    }

    @Override
    public List<ActorDto> selectActor(String docid) throws Exception {
        return cinemaMapper.selectActor(docid);
    }
    
    // 서버가 시작됬거나 갱신시간이 됬을때만 장르목록을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    @Override
    public Set<String> selectGenre() throws Exception {
        Set<String> genreSet = new HashSet<>();
        List<String> genreList = cinemaMapper.selectGenre();
        HashMap<String, Integer> genreCount = new HashMap<>(); // 해당 장르를 보유하고있는 영화의 개수를 세기위함
        
        for (String genres : genreList) {
            String[] splitGenre = genres.split(","); // SF,드라마 이런식으로 붙어있기때문에 자르기 작업 수행
            
            for (String genre : splitGenre) { // 선택한 장르가 저장소에 없다면 신규로 생성, 있다면 개수를 추가
                if (genreCount.get(genre) == null) {
                    genreCount.put(genre, 1);
                } else {
                    int count = genreCount.get(genre);
                    genreCount.put(genre, count + 1);
                }
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = genreCount.entrySet().iterator();
        while(iterator.hasNext()) { // 저장소에 장르의 개수가 3개 이상일경우에만 추출한다.
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() >= 3) {
                genreSet.add(entry.getKey());
            }
        }

        return genreSet; // 최종적으로는 중복이 제거되고 남은 장르의 목록을 반환
    }
    
    // 장르목록를 선택해서 9개의 영화만 고르는데 9개에서 현재 상영중인 영화를
    // 분류해서 반환한다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    @Override
    public HashMap<String, MovieDto> selectRecommendMoviesList(String genre) throws Exception {
        genre = "%" + genre + "%"; // DB LIKE 로 조회를 위해서 장르옆에 % 붙이기
        List<MovieDto> movies = cinemaMapper.selectRecommendMoviesList(genre);
        return sortViewAbleMovie(movies);
    }

    // 선택된 영화를 기준으로 현재 상영중인지를 분류한다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    private HashMap<String, MovieDto> sortViewAbleMovie(List<MovieDto> movies) throws Exception {
        List<String> titles = new ArrayList<>();
        HashMap<String, MovieDto> movieInfos = new HashMap<>();

        for (MovieDto movie : movies) { // 날짜가 가장 최근인 영화 9개를 가져온다.
            titles.add(movie.getTitle());
        }

        titles = cinemaMapper.selectViewAbleMovie(titles); // 현재 상영중인 영화 목록을 추려낸다.

        for (MovieDto movie : movies) { // 현재 상영중인 목록과 아닌 목록으로 분류한다.
            if (titles.contains(movie.getTitle())) {
                movieInfos.put(movie.getTitle() + "_Contain", movie);
            } else {
                movieInfos.put(movie.getTitle() + "_Noting", movie);
            }
        }

        return movieInfos;
    }
    
    // 관람등급을 기준으로 영화를 검색해서 조건에 일치하는 영화들을 가져온다.
    // 최종 수정 : 2022-12-21
    // 마지막 작성자 : MoonNight285
    @Override
    public HashMap<String, MovieDto> selectBirthMovieList(String id) throws Exception {
        int birth = cinemaMapper.selectUserBirth(id);
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int age = year - birth;
        List<String> movieRanks = new ArrayList<>();
        
        if (age < 12) {
            movieRanks.add("전체관람가");
        } else if (age < 15) {
            movieRanks.add("전체관람가");
            movieRanks.add("12세관람가");
        } else if (age < 18) {
            movieRanks.add("전체관람가");
            movieRanks.add("12세관람가");
            movieRanks.add("15세관람가");
        } else {
            movieRanks.add("전체관람가");
            movieRanks.add("12세관람가");
            movieRanks.add("15세관람가");
            movieRanks.add("18세관람가(청소년관람불가)");
        }
        
        List<MovieDto> movies = cinemaMapper.selectBirthMovieList(movieRanks);
        return sortViewAbleMovie(movies);
    }
}
