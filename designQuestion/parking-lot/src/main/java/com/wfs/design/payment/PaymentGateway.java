package com.wfs.design.payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.constant.PaymentType;

public class PaymentGateway {
	
	private List<PaymentStatergy> paymentStatergies;
	
	private Map<PaymentType ,PaymentStatergy > mapOfPaymnetTypeToStatergies;
	
	public PaymentGateway() {}
	
	public PaymentGateway(List<PaymentStatergy> paymentStatergies) {
		super();
		this.paymentStatergies = paymentStatergies;
		this.mapOfPaymnetTypeToStatergies =new HashMap<>();
	}		
	
	public PaymentStatus proceedToPayment(double amount , PaymentType type) {
		return mapOfPaymnetTypeToStatergies.get(type).proceed(amount);
	}
	
}
