package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plot")
public class PlotDto {
    private String plotText;
    
    @XmlElement
    public String getPlotText() {
        return plotText;
    }
    
    public void setPlotText(String plotText) {
        this.plotText = plotText;
    }
}
