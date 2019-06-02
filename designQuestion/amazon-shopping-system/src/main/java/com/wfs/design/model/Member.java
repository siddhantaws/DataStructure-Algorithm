package com.wfs.design.model;

import com.wfs.design.constant.CustomerType;
import com.wfs.design.constant.OrderStatus;
import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.service.PaymentService;

import java.util.List;

public class Member extends Customer {

  public Member() {
    super(CustomerType.MEMBER);
  }

  private List<Order> orders ;
  private Account account;

  private PaymentService paymentService;

  public OrderStatus placeOrder(){
      Order order =shoppingCart.checkout();
      orders.add(order);
      PaymentStatus paymentStatus  =    payment(account.getPaymentTypes().get(0), 100.0);
      order.setStatus(paymentStatus == PaymentStatus.COMPLETED ? OrderStatus.PAID : OrderStatus.PENDING);
      return order.getStatus();
  }

  public PaymentStatus payment(PaymentType paymentType , double amount){
      return paymentService.proceedToPayment(amount ,paymentType);
  }
}