package com.wfs.design.lot;

import com.wfs.design.constant.ParkingTicketStatus;

public class ParkingTicket {

	String tokenNumber;
	
	ParkingTicketStatus parkingTicketStatus;

	long timeStamp;
	
	public long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public ParkingTicketStatus getParkingTicketStatus() {
		return parkingTicketStatus;
	}

	public void setParkingTicketStatus(ParkingTicketStatus parkingTicketStatus) {
		this.parkingTicketStatus = parkingTicketStatus;
	}
	
	
	
}
