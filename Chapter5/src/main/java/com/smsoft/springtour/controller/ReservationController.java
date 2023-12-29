package com.smsoft.springtour.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ReservationController {
    @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations")
    public List<Long> getReservationsByPaging(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            Pageable pageable
    ) {
        System.out.println("Page param : " + pageable.getPageNumber());
        System.out.println("Size param : " + pageable.getPageSize());

        // sort가 여러개 일 수 있으므로 stream 돌리자
        // (sort객체는 inner클래스인 sort.order 객체 스트림을 구현한다)
        pageable.getSort().stream().forEach(order -> {
            System.out.println("Sort param : " + order.getProperty() + " : " + order.getDirection());
        });

        return Collections.emptyList();
    }
}
