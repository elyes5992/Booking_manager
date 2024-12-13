package com.example.Booking_manager.controller;

import com.example.Booking_manager.entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.Booking_manager.service.BookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Optional<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public boolean cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }
}

