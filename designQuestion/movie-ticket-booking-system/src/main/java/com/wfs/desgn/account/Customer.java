package com.wfs.desgn.account;

import com.wfs.desgn.booking.Booking;
import com.wfs.desgn.service.BookingService;

import java.util.List;

public class Customer extends Person {

    private BookingService bookingService;

    private List<Booking> bookings;

    public boolean makeBooking(Booking booking) {
        bookings.add(booking);
        return bookingService.makeBooking(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

}