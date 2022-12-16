package com.esc.springcinema.service;

import com.esc.springcinema.dto.PaymentsDto;

public interface PaymentService {

    public boolean paymentComplete(PaymentsDto payment) throws Exception;

}