package com.esc.springcinema.mapper;

import com.esc.springcinema.dto.BooksDto;
import com.esc.springcinema.dto.PaymentsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    void booking(BooksDto book) throws Exception;

    void bill(PaymentsDto payment) throws Exception;
}
