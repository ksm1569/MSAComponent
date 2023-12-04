package com.smsoft.springtour.service;

import com.smsoft.springtour.domain.ProductOrder;
import com.smsoft.springtour.domain.format.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.StringJoiner;

@Slf4j
@Service
public class OrderPrinter implements Printer<ProductOrder> {
    
    // 필드 주입
    @Autowired
    @Qualifier("localDateTimeFormatter")
    private Formatter formatter01;

    // setter 주입
    private Formatter formatter02;
    @Autowired
    public void setFormatter02(@Qualifier("localDateTimeFormatter") Formatter formatter) {
        this.formatter02 = formatter;
    }

    // 생성자 주입
    private Formatter formatter03;
    // @Autowired 생성자 주입은 스프링 관례상 생략가능
    public OrderPrinter(@Qualifier("localDateTimeFormatter") Formatter formatter) {
        this.formatter03 = formatter;
    }

    @Override
    public void print(OutputStream os, ProductOrder productOrder) throws IOException {
        StringJoiner joiner = new StringJoiner("\r\n");
        joiner.add(productOrder.getBuyerName());
        joiner.add(productOrder.getOrderAmount().toPlainString());
        joiner.add(formatter02.of(productOrder.getOrderAt()));

        os.write(joiner.toString().getBytes());
    }
}
