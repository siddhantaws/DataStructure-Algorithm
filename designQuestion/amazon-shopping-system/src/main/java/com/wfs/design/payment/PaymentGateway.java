package com.wfs.design.payment;

import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.model.PaymentType;
import java.util.Map;

public class PaymentGateway {

	private Map<PaymentType,PaymentStatergy> mapOfPaymnetTypeToStatergies;

	public PaymentStatus proceedToPayment(double amount , PaymentType type) {
		return mapOfPaymnetTypeToStatergies.get(type).proceed(amount);
	}

}
