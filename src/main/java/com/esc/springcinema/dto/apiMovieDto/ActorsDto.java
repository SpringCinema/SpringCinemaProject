package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "actors")
public class ActorsDto {
    private List<ActorDto> actors = new ArrayList<>();
    
    @XmlElement(name = "actor")
    public List<ActorDto> getActors() {
        return actors;
    }
    
    public void setActors(List<ActorDto> actors) {
        this.actors = actors;
    }
}
