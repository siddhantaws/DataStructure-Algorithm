package com.wfs.design.model;

import com.wfs.design.constant.PaymnetMode;

public class PaytmPayment extends PaymentType {

    private String phoneNumer ;
    public PaytmPayment() {
        super(PaymnetMode.PAYTM);
    }

}
