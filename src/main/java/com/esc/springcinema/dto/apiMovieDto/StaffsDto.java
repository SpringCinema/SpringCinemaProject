package com.esc.springcinema.dto.apiMovieDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "staffs")
public class StaffsDto {
    private List<StaffDto> staffs = new ArrayList<>();
    
    @XmlElement(name = "staff")
    public List<StaffDto> getStaffs() {
        return staffs;
    }
    
    public void setStaffs(List<StaffDto> staffs) {
        this.staffs = staffs;
    }
}
