package com.wfs.desgn.booking;

import com.wfs.desgn.constant.BookingStatus;
import com.wfs.desgn.movie.Show;
import com.wfs.desgn.payment.Payment;
import com.wfs.desgn.seat.ShowSeat;

import java.util.Date;
import java.util.List;

public class Booking {
  private String bookingNumber;
  private int numberOfSeats;
  private Date createdOn;
  private BookingStatus status;

  private Show show;
  private List<ShowSeat> seats;
  private Payment payment;

  public boolean makePayment(Payment payment){
    return false;
  }
  public boolean cancel(){
    return false;
  }
  public boolean assignSeats(List<ShowSeat> seats){
    return false;
  }
}