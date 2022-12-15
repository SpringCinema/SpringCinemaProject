package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Row")
public class MovieDto {
    private String docid;
    private String title;
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
    
    
    private StaffsDto staffs;
    
    @XmlElement(name = "DOCID")
    public String getDocid() {
        return docid;
    }
    
    public void setDocid(String docid) {
        this.docid = docid;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getNation() {
        return nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
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
        this.rating = rating;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getRepRlsDate() {
        return repRlsDate;
    }
    
    public void setRepRlsDate(String repRlsDate) {
        this.repRlsDate = repRlsDate;
    }
    
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    public String getPosters() {
        return posters;
    }
    
    public void setPosters(String posters) {
        this.posters = posters;
    }
    
    public String getStlls() {
        return stlls;
    }
    
    public void setStlls(String stlls) {
        this.stlls = stlls;
    }
    
    @XmlElement(name = "Awards1")
    public String getAwards1() {
        return awards1;
    }
    
    public void setAwards1(String awards1) {
        this.awards1 = awards1;
    }
    
    @XmlElement(name = "plots")
    public PlotsDto getPlotsDto() {
        return plotsDto;
    }
    
    public void setPlotsDto(PlotsDto plotsDto) {
        this.plotsDto = plotsDto;
    }
    
    @XmlElement(name = "staffs")
    public StaffsDto getStaffs() {
        return staffs;
    }
    
    public void setStaffs(StaffsDto staffs) {
        this.staffs = staffs;
    }
}
