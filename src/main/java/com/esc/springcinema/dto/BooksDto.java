package com.esc.springcinema.dto;

import lombok.Data;

@Data
public class BooksDto {
    private int idx;
    private String bookNum;
    private String id;
    private String reserveDate;
    private String title;
    private String seatCode;
    private String cinemaName;
    private String screenHallName;
    private String viewTime;
    private String adultYn;
    private String stateYn;
}
