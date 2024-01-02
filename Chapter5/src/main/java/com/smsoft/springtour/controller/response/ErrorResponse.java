package com.smsoft.springtour.controller.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
