package com.wfs.design.payment;

import com.wfs.design.constant.PaymentStatus;

public class DebitCardPaymentStatergy implements PaymentStatergy{

	@Override
	public PaymentStatus proceed(double amount) {
		// TODO Auto-generated method stub
		return PaymentStatus.SUCCESS;
	}
	
}
