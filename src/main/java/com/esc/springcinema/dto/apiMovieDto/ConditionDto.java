package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Condition")
public class ConditionDto {
    private String query;
    private String KMAQuery;
    private int totalCount;
    
    @XmlElement
    public String getQuery() {
        return query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public String getKMAQuery() {
        return KMAQuery;
    }
    
    public void setKMAQuery(String KMAQuery) {
        this.KMAQuery = KMAQuery;
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
