package com.smsoft.springtour.service;

import org.springframework.stereotype.Service;

//@Service
public class CircularReference {
    private CircularService circularService;

    public CircularReference(CircularService circularService) {
        this.circularService = circularService;
    }
}
