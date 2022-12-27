package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement(name = "Row")
public class MovieDto {
    private String docid;
    private String title;
    private String titleEng;
    private String nation;
    private String company;
    private int runtime;
    private String rating;
    private String genre;
    private String repRlsDate;
    private String keywords;
    private String posters;
    private String stlls;
    private String awards1;
    private PlotsDto plotsDto;
    private DirectorsDto directorsDto;
    private ActorsDto actorsDto;
    
    @XmlElement(name = "actors")
    public ActorsDto getActorsDto() {
        return actorsDto;
    }
    
    public void setActorsDto(ActorsDto actorsDto) {
        this.actorsDto = actorsDto;
    }
    
    @XmlElement(name = "directors")
    public DirectorsDto getDirectorsDto() {
        return directorsDto;
    }
    
    public void setDirectorsDto(DirectorsDto directorsDto) {
        this.directorsDto = directorsDto;
    }
    
    @XmlElement(name = "DOCID")
    public String getDocid() {
        return docid;
    }
    
    public void setDocid(String docid) {
        if (docid != null)
            this.docid = docid.trim();
    }
    
    public String getTitle() {
        return title;
    }

    // 제목에 태그가 붙어서 들어오는 경우가 있어서 제거후 저장
    // 작성일 : 2022-12-15
    // 작성자 : MoonNigth285
    public void setTitle(String title) {
        if (title != null) {
            title = title.trim();
            String[] splitTitle = title.split("<!HS>|<!HE>");
    
            this.title = "";
            for (int i = 0; i < splitTitle.length; ++i) {
                this.title += splitTitle[i];
            }
        }
    }
    
    public String getTitleEng() {
        return titleEng;
    }
    
    public void setTitleEng(String titleEng) {
        if (titleEng != null)
            this.titleEng = titleEng.trim();
    }
    
    public String getNation() {
        return nation;
    }
    
    public void setNation(String nation) {
        if (nation != null)
            this.nation = nation.trim();
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        if (company != null)
            this.company = company.trim();
    }
    
    public int getRuntime() {
        return runtime;
    }
    
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        if (rating != null)
            this.rating = rating.trim();
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        if (genre != null)
            this.genre = genre.trim();
    }
    
    public String getRepRlsDate() {
        return repRlsDate;
    }

    // API가 날짜형식을 20221215 형태로 주기때문에 하이픈을 붙여서 DB에 저장
    // 그리고 DB에서 꺼낼때 하이픈이 붙여있는 상태로 저장될수있기때문에 relaceAll을 통해 제거후 다시 붙임
    // 수정일 : 2022-12-15
    // 작성자 : MoonNigth285
    public void setRepRlsDate(String repRlsDate) throws Exception {
        if (repRlsDate != null) {
            repRlsDate = repRlsDate.trim();
            repRlsDate = repRlsDate.replaceAll("-","");
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date formatDate = dtFormat.parse(repRlsDate);
            this.repRlsDate = newDtFormat.format(formatDate);
        }
    }
    
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        if (keywords != null)
            this.keywords = keywords.trim();
    }
    
    public String getPosters() {
        return posters;
    }
    
    public void setPosters(String posters) {
        if (posters != null)
            this.posters = posters.trim();
    }
    
    public String getStlls() {
        return stlls;
    }
    
    public void setStlls(String stlls) {
        if (stlls != null)
            this.stlls = stlls.trim();
    }
    
    @XmlElement(name = "Awards1")
    public String getAwards1() {
        return awards1;
    }
    
    public void setAwards1(String awards1) {
        if (awards1 != null)
            this.awards1 = awards1.trim();
    }
    
    @XmlElement(name = "plots")
    public PlotsDto getPlotsDto() {
        return plotsDto;
    }
    
    public void setPlotsDto(PlotsDto plotsDto) {
        this.plotsDto = plotsDto;
    }

    private String keyword;
}
