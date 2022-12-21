package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.PaymentsDto;

public interface PaymentService {

    public boolean paymentComplete(PaymentsDto payment) throws Exception;

    void booking(BooksDto book) throws Exception;
}