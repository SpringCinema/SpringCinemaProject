package com.esc.springcinema.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String name;
    private String birth;
    private String gender;
    private String email;
    private String tel;
    private String joinDate;
    private String outDate;
}
