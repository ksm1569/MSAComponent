package com.smsoft.springtour.controller.exception;

import com.smsoft.springtour.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        System.out.println("Error Message : " + ex.getErrorMessage());

        return new ResponseEntity<>(
                new ErrorResponse(ex.getErrorMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(FileDownLoadException.class)
    public ResponseEntity handleFileDownLoadException(FileDownLoadException e) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse("system error"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
