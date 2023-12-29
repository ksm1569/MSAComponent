package com.smsoft.springtour.controller.request;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class HotelRoomReserveRequest {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String name;
}
