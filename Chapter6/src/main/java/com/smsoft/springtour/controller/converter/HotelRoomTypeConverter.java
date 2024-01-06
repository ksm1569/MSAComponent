package com.smsoft.springtour.controller.converter;

import com.smsoft.springtour.controller.HotelRoomType;
import org.springframework.core.convert.converter.Converter;

public class HotelRoomTypeConverter implements Converter<String, HotelRoomType> {
    @Override
    public HotelRoomType convert(String source) {
        return HotelRoomType.fromParam(source);
    }
}
