package com.wfs.design.model;

import com.wfs.design.constant.OrderStatus;

import java.util.Date;

public class OrderLog {

  private String orderNumber;
  private Date creationDate;
  private OrderStatus status;

  public OrderLog(String orderNumber, Date creationDate, OrderStatus status) {
    this.orderNumber = orderNumber;
    this.creationDate = creationDate;
    this.status = status;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}