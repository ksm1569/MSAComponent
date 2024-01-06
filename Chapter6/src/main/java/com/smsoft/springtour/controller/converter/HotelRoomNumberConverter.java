package com.smsoft.springtour.controller.converter;

import com.smsoft.springtour.domain.HotelRoomNumber;
import org.springframework.core.convert.converter.Converter;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {
    @Override
    public HotelRoomNumber convert(String source) {
        return HotelRoomNumber.parse(source);
    }
}
