package com.wfs.design.vechile;

import com.wfs.design.constant.VehicleType;
import com.wfs.design.lot.ParkingTicket;

public abstract class Vehicle {
  private String licenseNumber;
  private final VehicleType type;
  private ParkingTicket ticket;

  public Vehicle(VehicleType type) {
    this.type = type;
  }

  public void assignTicket(ParkingTicket ticket) {
    this.ticket = ticket;
  }

public VehicleType getType() {
	return type;
}
  
  
}

