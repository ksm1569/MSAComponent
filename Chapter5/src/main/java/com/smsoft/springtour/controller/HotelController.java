package com.smsoft.springtour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {



    /*
    * @GetMapping 어노테이션을 까보자
    * path, value, name, consumes(Content-type), produces(Accept) -> OR연산
    * params, headers -> AND연산
    * */
    @GetMapping(path = "/hotels")
    public void getHotels() {
        System.out.println("getHotels");
    }

    // http://localhost:8080/hotels?open
    @GetMapping(path = "/hotels", params = "open")
    public void getHotelsByOpen() {
        System.out.println("getHotelsByOpen");
    }
}
