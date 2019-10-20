package com.design.pattern.strategy;

public class CreditcardPaymentStatergy implements PaymentStatergy {
    private String cadname;
    private String cadnumber;
    private String cvv;

    public CreditcardPaymentStatergy(String cadname, String cadnumber, String cvv) {
        this.cadname = cadname;
        this.cadnumber = cadnumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(double abmout) {
        System.out.println("Paid : "+abmout);
    }
}
