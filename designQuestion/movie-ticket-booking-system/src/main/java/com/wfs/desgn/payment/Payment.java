package com.wfs.desgn.payment;

import com.wfs.desgn.constant.PaymentStatus;

import java.util.Date;

public class Payment {
  private double amount;
  private Date createdOn;
  private int transactionId;
  private PaymentStatus status;

  public Payment(){}

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  public Payment(double amount, Date createdOn, int transactionId, PaymentStatus status) {
    this.amount = amount;
    this.createdOn = createdOn;
    this.transactionId = transactionId;
    this.status = status;
  }
}