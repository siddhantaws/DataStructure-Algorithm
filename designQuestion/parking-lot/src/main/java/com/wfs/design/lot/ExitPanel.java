package com.wfs.design.lot;

import com.wfs.design.constant.ParkingTicketStatus;
import com.wfs.design.constant.PaymentStatus;
import com.wfs.design.constant.PaymentType;
import com.wfs.design.payment.PaymentGateway;

public class ExitPanel {
	
	private String name ;
	
	private ParkingLot parkingLot;
	
	private PaymentGateway  gateway ;
	
	public ExitPanel(String name,ParkingLot parkingLot ,PaymentGateway  gateway) {
		super();
		this.name = name;
		this.parkingLot =parkingLot;
		this.gateway =new PaymentGateway();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void scanTicket(ParkingTicket parkingTicket) {
		parkingLot.processParkingTicket(parkingTicket);
	}
	
	public void doPayment(ParkingTicket parkingTicket) {
		PaymentStatus status =gateway.proceedToPayment(0.0d, PaymentType.CREDIT_CARD);
		switch(status) {
			case SUCCESS :
				parkingTicket.setParkingTicketStatus(ParkingTicketStatus.PAID);
		}
	}
	
}
