package com.design.pattern.strategy;

public class CartService {

    PaymentStatergy paymentStatergy;

    public void setPaymentStatergy(PaymentStatergy paymentStatergy) {
        this.paymentStatergy = paymentStatergy;
    }


    public void pay(double amount){
        paymentStatergy.pay(amount);
    }
}
