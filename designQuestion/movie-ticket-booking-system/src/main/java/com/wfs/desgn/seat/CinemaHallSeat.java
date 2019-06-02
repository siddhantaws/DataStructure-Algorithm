package com.wfs.desgn.seat;

import com.wfs.desgn.constant.SeatType;

public class CinemaHallSeat {
    private String row;
    private String col;
    private SeatType seatType;

    public CinemaHallSeat(){

    }

    public CinemaHallSeat(String row, String col, SeatType seatType) {
        this.row = row;
        this.col = col;
        this.seatType = seatType;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
