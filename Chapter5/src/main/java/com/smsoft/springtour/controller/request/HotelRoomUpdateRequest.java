package com.smsoft.springtour.controller.request;

import com.smsoft.springtour.domain.HotelRoomType;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ToString
@Getter
public class HotelRoomUpdateRequest {

    @NotNull(message = "roomType can`t be null")
    private HotelRoomType hotelRoomType;

    @NotNull(message = "originalPrice can`t be null")
    @Min(value = 0, message = "orginalPrice must be larger than 0")
    private BigDecimal originalPrice;
}
