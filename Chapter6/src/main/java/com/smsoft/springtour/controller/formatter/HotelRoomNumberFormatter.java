package com.smsoft.springtour.controller.formatter;

import com.smsoft.springtour.domain.HotelRoomNumber;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class HotelRoomNumberFormatter implements Formatter<HotelRoomNumber> {
    // 다국어 처리 가능
    @Override
    public HotelRoomNumber parse(String text, Locale locale) throws ParseException {
        return HotelRoomNumber.parse(text);
    }
    @Override
    public String print(HotelRoomNumber hotelRoomNumber, Locale locale) {
        return hotelRoomNumber.toString();
    }
}
