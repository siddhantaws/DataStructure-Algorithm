package com.wfs.design.exception;

public class ParkingFullException extends RuntimeException{
	private static String MESSAGE ="Parking is FULL";
	
	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
