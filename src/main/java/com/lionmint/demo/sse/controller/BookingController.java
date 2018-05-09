package com.lionmint.demo.sse.controller;

import com.lionmint.demo.sse.domain.HotelBooking;
import com.lionmint.demo.sse.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/bookings")
class BookingController {

    @Autowired
    HotelBookingService hotelBookingService;

    @GetMapping(produces = "text/event-stream")
    public Flux<HotelBooking> bookingEvents() {
        return hotelBookingService.getBookings();
    }
}