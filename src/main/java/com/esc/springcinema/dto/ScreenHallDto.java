package com.esc.springcinema.dto;

import lombok.Data;

@Data
public class ScreenHallDto {
    private int idx;
    private String cinemaName;
    private String screenHallName;
    private String movieTitle;
    private String am1;
    private String am2;
    private String pm1;
    private String pm2;
}
