package com.wfs.design.lot;

import com.wfs.design.spot.CompactSpot;
import com.wfs.design.spot.ElectricSpot;
import com.wfs.design.spot.HandicappedSpot;
import com.wfs.design.spot.LargeSpot;
import com.wfs.design.spot.MotorbikeSpot;

public class ParkingDisplayBoard {
	private String id;

	private HandicappedSpot handicappedFreeSpot;
	private CompactSpot compactFreeSpot;
	private LargeSpot largeFreeSpot;
	private MotorbikeSpot motorbikeFreeSpot;
	private ElectricSpot electricFreeSpot;
	
	
	public void showEmptySpotNumber() {
		StringBuffer message = new StringBuffer();
		if (handicappedFreeSpot.IsFree()) {
			message.append("Free Handicapped: " + handicappedFreeSpot.getNumber());
		} else {
			message.append("Handicapped is full");
		}
		message.append("\n");

		if (compactFreeSpot.IsFree()) {
			message.append("Free Compact: " + compactFreeSpot.getNumber());
		} else {
			message.append("Compact is full");
		}
		message.append("\n");

		if (largeFreeSpot.IsFree()) {
			message.append("Free Large: " + largeFreeSpot.getNumber());
		} else {
			message.append("Large is full");
		}
		message.append("\n");

		if (motorbikeFreeSpot.IsFree()) {
			message.append("Free Motorbike: " + motorbikeFreeSpot.getNumber());
		} else {
			message.append("Motorbike is full");
		}
		message.append("\n");

		if (electricFreeSpot.IsFree()) {
			message.append("Free Electric: " + electricFreeSpot.getNumber());
		} else {
			message.append("Electric is full");
		}

		System.out.println(message.toString());
	}
}