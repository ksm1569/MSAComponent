package com.smsoft.springtour.service;

import org.springframework.stereotype.Service;

//@Service
public class CircularService {
    private CircularReference circularReference;

    public CircularService(CircularReference circularReference) {
        this.circularReference = circularReference;
    }
}
