package com.example.Booking_manager.service;

import com.example.Booking_manager.entity.Booking;
import lombok.RequiredArgsConstructor;
import com.example.Booking_manager.repo.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        booking.setCreatedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public Optional<Booking> updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setClientName(updatedBooking.getClientName());
            booking.setClientEmail(updatedBooking.getClientEmail());
            booking.setService(updatedBooking.getService());
            booking.setEventDate(updatedBooking.getEventDate());
            booking.setStatus(updatedBooking.getStatus());
            booking.setUpdatedAt(LocalDateTime.now());
            return bookingRepository.save(booking);
        });
    }

    public boolean cancelBooking(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setStatus(Booking.Status.CANCELED);
            booking.setUpdatedAt(LocalDateTime.now());
            bookingRepository.save(booking);
            return true;
        }).orElse(false);
    }
}

