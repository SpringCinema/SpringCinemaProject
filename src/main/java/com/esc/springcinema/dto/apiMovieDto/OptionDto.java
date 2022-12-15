package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Options")
public class OptionDto {
    private int pageNo; // 페이지 번호
    private int numOfRow; // 검색개수
    private String searchField; // ?
    private String sort; // ?
    private String dateRange; // ?
    
    @XmlElement
    public int getNumOfRow() {
        return numOfRow;
    }
    
    public void setNumOfRow(int numOfRow) {
        this.numOfRow = numOfRow;
    }
    
    public String getSearchField() {
        return searchField;
    }
    
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }
    
    public String getSort() {
        return sort;
    }
    
    public void setSort(String sort) {
        this.sort = sort;
    }
    
    public String getDateRange() {
        return dateRange;
    }
    
    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }
    
    public int getPageNo() {
        return pageNo;
    }
    
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
