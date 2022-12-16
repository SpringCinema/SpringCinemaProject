package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "director")
public class DirectorDto {
    private String directorNm;
    
    @XmlElement
    public String getDirectorNm() {
        return directorNm;
    }
    
    public void setDirectorNm(String directorNm) {
        if (directorNm != null)
            this.directorNm = directorNm.trim();
    }
}
