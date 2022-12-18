package com.esc.springcinema.dto;

import lombok.Data;

@Data
public class PaymentsDto {
    private int idx;
    private String paymentNum;
    private String id;
    private int money;
    private String payType;
    private String title;
    private String payDate;
    private String state;
}
