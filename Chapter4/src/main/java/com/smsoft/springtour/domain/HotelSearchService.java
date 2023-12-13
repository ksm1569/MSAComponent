package com.smsoft.springtour.domain;

import org.springframework.stereotype.Service;

@Service
public class HotelSearchService {
    public Hotel getHotelById(Long hotelId) {
        return new Hotel(hotelId,
                "The Hotel",
                "busan 123",
                100
        );
    }
}
