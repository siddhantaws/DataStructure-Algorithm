package com.wfs.design.payment;

import com.wfs.design.constant.PaymentStatus;

public interface PaymentStatergy {
	public PaymentStatus proceed(double amount) ;
}
