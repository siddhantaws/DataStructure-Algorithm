package com.wfs.design.service;

import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.model.PaymentType;

public interface PaymentService {
    public PaymentStatus proceedToPayment(double amount , PaymentType type);
}
