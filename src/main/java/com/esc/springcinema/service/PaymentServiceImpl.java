package com.esc.springcinema.service;

import com.esc.springcinema.dto.PaymentsDto;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean paymentComplete(PaymentsDto payment) throws Exception {
        return false;
    }
}
