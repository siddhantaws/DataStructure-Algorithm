package com.wfs.design.model;

import java.util.Date;
import java.util.List;

public class Shipment {

  private String shipmentNumber;

  private Date shipmentDate;

  private Date estimatedArrival;

  private String shipmentMethod;

  private List<ShipmentLog> shipmentLogs;


  public Shipment(String shipmentNumber, Date shipmentDate, Date estimatedArrival, String shipmentMethod, List<ShipmentLog> shipmentLogs) {
    this.shipmentNumber = shipmentNumber;
    this.shipmentDate = shipmentDate;
    this.estimatedArrival = estimatedArrival;
    this.shipmentMethod = shipmentMethod;
    this.shipmentLogs = shipmentLogs;
  }


  public String getShipmentNumber() {
    return shipmentNumber;
  }

  public void setShipmentNumber(String shipmentNumber) {
    this.shipmentNumber = shipmentNumber;
  }

  public Date getShipmentDate() {
    return shipmentDate;
  }

  public void setShipmentDate(Date shipmentDate) {
    this.shipmentDate = shipmentDate;
  }

  public Date getEstimatedArrival() {
    return estimatedArrival;
  }

  public void setEstimatedArrival(Date estimatedArrival) {
    this.estimatedArrival = estimatedArrival;
  }

  public String getShipmentMethod() {
    return shipmentMethod;
  }

  public void setShipmentMethod(String shipmentMethod) {
    this.shipmentMethod = shipmentMethod;
  }

  public List<ShipmentLog> getShipmentLogs() {
    return shipmentLogs;
  }

  public void setShipmentLogs(List<ShipmentLog> shipmentLogs) {
    this.shipmentLogs = shipmentLogs;
  }

  public boolean addShipmentLog(ShipmentLog shipmentLog){
    this.shipmentLogs.add(shipmentLog);
    return true;
  }


}