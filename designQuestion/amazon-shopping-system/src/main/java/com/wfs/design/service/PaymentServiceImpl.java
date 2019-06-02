package com.wfs.design.service;

import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.model.PaymentType;
import com.wfs.design.payment.PaymentGateway;

public class PaymentServiceImpl implements PaymentService  {
    private PaymentGateway paymentGateway;

    @Override
    public PaymentStatus proceedToPayment(double amount, PaymentType type) {
        return paymentGateway.proceedToPayment(amount,type);
    }
}
