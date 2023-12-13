package com.smsoft.springtour.controller;

import com.smsoft.springtour.domain.Hotel;
import com.smsoft.springtour.domain.HotelSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApiController {
    private HotelSearchService hotelSearchService;

    public ApiController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") Long hotelId) {
        Hotel hotel = hotelSearchService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);

        //status 열거형 예제
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hotel);
    }
}
