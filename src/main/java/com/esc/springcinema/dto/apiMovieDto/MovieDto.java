package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
    
    public void setRepRlsDate(String repRlsDate) {
        if (repRlsDate != null) {
            repRlsDate = repRlsDate.trim();
            String year = repRlsDate.substring(0, 4);
            String month = repRlsDate.substring(4, 6);
            String day = repRlsDate.substring(6);
            this.repRlsDate = year + "-" + month + "-" + day;
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
}
