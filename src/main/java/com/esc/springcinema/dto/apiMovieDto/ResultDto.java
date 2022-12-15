package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Result")
public class ResultDto {
    private List<MovieDto> movies = new ArrayList<>();
    
    @XmlElement(name = "Row")
    public List<MovieDto> getMovies() {
        return movies;
    }
    
    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }
}
