package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Search")
public class SearchDto {
    private OptionDto option = new OptionDto();
    private ConditionDto condition = new ConditionDto();
    private ResultDto result = new ResultDto();
    
    @XmlElement(name = "Option")
    public OptionDto getOption() {
        return option;
    }
    
    public void setOption(OptionDto option) {
        this.option = option;
    }
    
    @XmlElement(name = "Condition")
    public ConditionDto getCondition() {
        return condition;
    }
    
    public void setCondition(ConditionDto condition) {
        this.condition = condition;
    }
    
    @XmlElement(name = "Result")
    public ResultDto getResult() {
        return result;
    }
    
    public void setResult(ResultDto result) {
        this.result = result;
    }
}
