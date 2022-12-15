package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plots")
public class PlotsDto {
    private PlotDto plotDto = new PlotDto();
    
    @XmlElement(name = "plot")
    public PlotDto getPlotDto() {
        return plotDto;
    }
    
    public void setPlotDto(PlotDto plotDto) {
        this.plotDto = plotDto;
    }
}
