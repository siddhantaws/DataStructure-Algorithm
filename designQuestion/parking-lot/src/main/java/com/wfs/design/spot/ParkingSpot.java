package com.wfs.design.spot;

import com.wfs.design.constant.ParkingSpotType;
import com.wfs.design.vechile.Vehicle;

public abstract class ParkingSpot {
  private String number;
  private boolean free;
  private Vehicle vehicle;
  private final ParkingSpotType type;

  
  public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public boolean IsFree() {
	  return free;
  }

  public ParkingSpotType getType() {
	return type;
}

public ParkingSpot(ParkingSpotType type) {
    this.type = type;
  }

  public boolean assignVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    return free = false;
  }

  public boolean removeVehicle() {
    this.vehicle = null;
    return free = true;
  }
  
}

