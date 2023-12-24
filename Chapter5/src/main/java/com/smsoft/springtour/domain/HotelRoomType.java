package com.smsoft.springtour.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum HotelRoomType {
    SINGLE("single"),
    DOUBLE("double"),
    TRIPLE("triple"),
    QUAD("quad");

    private static final Map<String, HotelRoomType> paramMap = Arrays.stream(HotelRoomType.values())
            .collect(Collectors.toMap(
                    HotelRoomType::getParam,
                    Function.identity()
            ));

    private final String param;

    // enum 상수를 선언할때 json 객체 값으로 사용될 값을 인수로 입력
    // ex) SINGLE상수는 문자열 "single" 이 param 값으로 할당
    HotelRoomType(String param) {
        this.param = param;
    }

    @JsonCreator
    public static HotelRoomType fromParam(String param) {
        return Optional.ofNullable(param)
                .map(paramMap::get)
                .orElseThrow(() -> new IllegalArgumentException("param is not valid"));
    }

    @JsonValue
    public String getParam() {
        return this.param;
    }
}
