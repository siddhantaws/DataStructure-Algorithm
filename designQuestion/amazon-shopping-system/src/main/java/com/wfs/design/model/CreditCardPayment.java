package com.wfs.design.model;

import com.wfs.design.constant.PaymnetMode;

public class CreditCardPayment extends PaymentType {

    private  String cardNumber ;


    public CreditCardPayment() {
        super(PaymnetMode.CREDIT_CARD);
    }


}
