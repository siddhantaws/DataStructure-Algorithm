package com.wfs.design.lot;

import com.wfs.design.vechile.Vehicle;

public class EntrancePanel {
	private String  name;
	
	private ParkingLot parkingLot;
	
	public EntrancePanel(String name,ParkingLot parkingLot) {
		super();
		this.name = name;
		this.parkingLot =parkingLot;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ParkingTicket getTicket(Vehicle vehicle) {
		return parkingLot.getNewParkingTicket(vehicle);
	}
	
}
