package com.esc.springcinema.service;

import com.esc.springcinema.dto.MemberDto;
import com.esc.springcinema.dto.ScreenHallDto;

import java.util.List;

public interface CinemaService {

    ScreenHallDto selectScreenData(String movieTitle, String cinemaName, String screenHallName);
}
