package com.smsoft.springtour.domain;

import lombok.Getter;

import java.util.StringJoiner;

@Getter
public class HotelRoomNumber {
    // /hotels/{hotelId}/rooms/{roomNumber}
    // GET /hotels/3642/rooms/ocean-1024
    // ocean-1024
    private static final String DELIMITER = "-";

    private String buildingCode;
    private Long roomNumber;

    public HotelRoomNumber(String buildingCode, Long roomNumber) {
        this.buildingCode = buildingCode;
        this.roomNumber = roomNumber;
    }

    public static final HotelRoomNumber parse(String roomNumberId) {
        String[] tokens = roomNumberId.split(DELIMITER);

        if(tokens.length!=2)
            throw new IllegalArgumentException("invalid roomNumberId format");

        return new HotelRoomNumber(tokens[0], Long.parseLong(tokens[1]));
    }

    @Override
    public String toString() {
        return new StringJoiner(DELIMITER)
                .add(buildingCode)
                .add(roomNumber.toString())
                .toString();
    }
}
