package com.design.pattern.strategy;

public class PaytmPaymentStatergy implements PaymentStatergy {

    private String phoneNumber;

    public PaytmPaymentStatergy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double abmout) {
        System.out.println("Paid : "+abmout);
    }
}
