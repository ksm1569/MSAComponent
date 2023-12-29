package com.smsoft.springtour.controller;

import com.smsoft.springtour.controller.request.HotelRoomReserveRequest;
import com.smsoft.springtour.controller.response.HotelRoomIdResponse;
import com.smsoft.springtour.domain.reservation.ReserveService;
import com.smsoft.springtour.validator.HotelRoomReserveValidator;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HotelRoomReserveController {
    private final ReserveService reserveService;

    public HotelRoomReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @InitBinder
    void initBind(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMessage = bindingResult.getFieldError().getCode() +
                    " [" + fieldError.getField() + "] " +
                    fieldError.getDefaultMessage();

            System.out.println("error : " + errorMessage);
            return ResponseEntity.badRequest().build();
        }

        System.out.println(reserveRequest.toString());

        Long reservationId = reserveService.reserveHotelRoom(hotelId, roomNumber,
                reserveRequest.getCheckInDate(),
                reserveRequest.getCheckOutDate());

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);
        return ResponseEntity.ok(body);
    }

}
