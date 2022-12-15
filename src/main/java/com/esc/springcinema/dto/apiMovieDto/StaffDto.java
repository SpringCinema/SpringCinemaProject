package com.esc.springcinema.dto.apiMovieDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "staff")
public class StaffDto {
    private int idx; // 실제 XML에 미포함, 내부 DB에서 존재
    private String docid; // 실제 XML에 미포함, 내부 DB에서 존재
    private String staffNm;
    private String staffRoleGroup;
    
    @XmlElement
    public int getIdx() {
        return idx;
    }
    
    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public String getDocid() {
        return docid;
    }
    
    public void setDocid(String docid) {
        this.docid = docid;
    }
    
    public String getStaffNm() {
        return staffNm;
    }
    
    public void setStaffNm(String staffNm) {
        this.staffNm = staffNm;
    }
    
    public String getStaffRoleGroup() {
        return staffRoleGroup;
    }
    
    public void setStaffRoleGroup(String staffRoleGroup) {
        this.staffRoleGroup = staffRoleGroup;
    }
    
    public String getStaffRole() {
        return staffRole;
    }
    
    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }
    
    private String staffRole;
}
