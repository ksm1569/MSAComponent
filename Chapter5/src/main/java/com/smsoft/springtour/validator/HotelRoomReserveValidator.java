package com.smsoft.springtour.validator;

import com.smsoft.springtour.controller.request.HotelRoomReserveRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class HotelRoomReserveValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return HotelRoomReserveRequest.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        HotelRoomReserveRequest reserveRequest = HotelRoomReserveRequest.class.cast(target);

        if (Objects.isNull(reserveRequest.getCheckInDate())) {
            errors.rejectValue("checkInDate", "NotNull", "checkInDate is null");
        }
        if (Objects.isNull(reserveRequest.getCheckOutDate())) {
            errors.rejectValue("checkOutDate", "NotNull", "checkOutDate is null");
        }
        if (reserveRequest.getCheckInDate().compareTo(reserveRequest.getCheckOutDate()) >= 0) {
            errors.rejectValue("checkOutDate", "Constraint Error", "checkOutDate is earlier than checkInDate");
        }
    }
}
