package com.wfs.design.model;

import com.wfs.design.constant.ShipmentStatus;

import java.util.Date;

public class ShipmentLog {
  private String shipmentNumber;
  private ShipmentStatus status;
  private Date creationDate;

  public ShipmentLog(String shipmentNumber, ShipmentStatus status, Date creationDate) {
    this.shipmentNumber = shipmentNumber;
    this.status = status;
    this.creationDate = creationDate;
  }

  public String getShipmentNumber() {
    return shipmentNumber;
  }

  public void setShipmentNumber(String shipmentNumber) {
    this.shipmentNumber = shipmentNumber;
  }

  public ShipmentStatus getStatus() {
    return status;
  }

  public void setStatus(ShipmentStatus status) {
    this.status = status;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}