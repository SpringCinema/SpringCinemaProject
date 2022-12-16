package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "directors")
public class DirectorsDto {
    private DirectorDto directorDto = new DirectorDto();
    
    @XmlElement(name = "director")
    public DirectorDto getDirectorDto() {
        return directorDto;
    }
    
    public void setDirectorDto(DirectorDto directorDto) {
        this.directorDto = directorDto;
    }
}
