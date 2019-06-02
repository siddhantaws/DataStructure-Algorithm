package com.wfs.design.model;

import com.wfs.design.constant.PaymnetMode;

public abstract class PaymentType {

    private PaymnetMode paymnetMode;

    public PaymentType(PaymnetMode paymnetMode) {
        this.paymnetMode = paymnetMode;
    }


}
