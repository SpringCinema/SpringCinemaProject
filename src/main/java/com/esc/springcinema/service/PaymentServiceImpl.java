package com.esc.springcinema.service;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.PaymentsDto;
import com.esc.springcinema.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public boolean paymentComplete(PaymentsDto payment) throws Exception {
        return false;
    }

    @Override
    public void booking(BooksDto book) throws Exception {
        paymentMapper.booking(book);
    }

    @Override
    public void bill(PaymentsDto payment) throws Exception {
        paymentMapper.bill(payment);
    }
}
