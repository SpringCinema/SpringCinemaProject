package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "actor")
public class ActorDto {
    private String actorNm;
    
    @XmlElement
    public String getActorNm() {
        return actorNm;
    }
    
    public void setActorNm(String actorNm) {
        if (actorNm != null)
            this.actorNm = actorNm.trim();
    }
}
