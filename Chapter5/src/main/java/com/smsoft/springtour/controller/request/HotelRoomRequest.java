package com.smsoft.springtour.controller.request;

import com.smsoft.springtour.domain.HotelRoomType;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class HotelRoomRequest {
    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}
