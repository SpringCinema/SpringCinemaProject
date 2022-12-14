package com.esc.springcinema.dto;

import lombok.Data;

import java.util.List;

@Data
public class MoviesDto {
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
    private String plotText;

    private List<StaffsDto> staffs;
}
