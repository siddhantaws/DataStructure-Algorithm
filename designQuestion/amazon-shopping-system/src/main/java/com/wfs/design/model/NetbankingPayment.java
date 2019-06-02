package com.wfs.design.model;

import com.wfs.design.constant.PaymnetMode;

public class NetbankingPayment extends PaymentType {

    private String accountNumber;

    public NetbankingPayment() {
        super(PaymnetMode.NETBANKING);
    }

}
