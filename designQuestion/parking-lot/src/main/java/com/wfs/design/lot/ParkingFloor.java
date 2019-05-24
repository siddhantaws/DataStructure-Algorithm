package com.wfs.design.lot;

import java.util.HashMap;

import com.wfs.design.constant.ParkingSpotType;
import com.wfs.design.spot.CompactSpot;
import com.wfs.design.spot.ElectricSpot;
import com.wfs.design.spot.HandicappedSpot;
import com.wfs.design.spot.LargeSpot;
import com.wfs.design.spot.MotorbikeSpot;
import com.wfs.design.spot.ParkingSpot;
import com.wfs.design.vechile.Vehicle;

public class ParkingFloor {
	private String name;
	private HashMap<String, ParkingSpot> handicappedSpots = new HashMap<>();
	private HashMap<String, ParkingSpot> compactSpots = new HashMap<>();
	private HashMap<String, ParkingSpot> largeSpots = new HashMap<>();
	private HashMap<String, ParkingSpot> motorbikeSpots = new HashMap<>();
	private HashMap<String, ParkingSpot> electricSpots = new HashMap<>();

	private int freeElectricSpotCount;
	private int freeCompactSpotCount;
	private int freeLargeSpotCount;
	private int freeMotorbikeSpotCount;

	public int getFreeElectricSpotCount() {
		return freeElectricSpotCount;
	}

	public void setFreeElectricSpotCount(int freeElectricSpotCount) {
		this.freeElectricSpotCount = freeElectricSpotCount;
	}

	public int getFreeCompactSpotCount() {
		return freeCompactSpotCount;
	}

	public void setFreeCompactSpotCount(int freeCompactSpotCount) {
		this.freeCompactSpotCount = freeCompactSpotCount;
	}

	public int getFreeLargeSpotCount() {
		return freeLargeSpotCount;
	}

	public void setFreeLargeSpotCount(int freeLargeSpotCount) {
		this.freeLargeSpotCount = freeLargeSpotCount;
	}

	public int getFreeMotorbikeSpotCount() {
		return freeMotorbikeSpotCount;
	}

	public void setFreeMotorbikeSpotCount(int freeMotorbikeSpotCount) {
		this.freeMotorbikeSpotCount = freeMotorbikeSpotCount;
	}

	private ParkingDisplayBoard displayBoard;

	public ParkingFloor(String name) {
		this.name = name;
	}

	public ParkingFloor(ParkingFloorBuilder builder) {
		this.name = builder.name;
		this.freeElectricSpotCount = builder.freeCompactSpotCount;
		this.freeCompactSpotCount = builder.freeCompactSpotCount;
		this.freeLargeSpotCount = builder.freeLargeSpotCount;
		this.freeMotorbikeSpotCount = builder.freeMotorbikeSpotCount;
		this.displayBoard = builder.displayBoard;
	}

	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
		case HANDICAPPED:
			handicappedSpots.put(spot.getNumber(), spot);
			break;
		case COMPACT:
			compactSpots.put(spot.getNumber(), spot);
			break;
		case LARGE:
			largeSpots.put(spot.getNumber(), spot);
			break;
		case MOTORBIKE:
			motorbikeSpots.put(spot.getNumber(), spot);
			break;
		case ELECTRIC:
			electricSpots.put(spot.getNumber(), spot);
			break;
		default:
			print("Wrong parking spot type!");
		}
	}

	public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
		spot.assignVehicle(vehicle);
		switch (spot.getType()) {
		case HANDICAPPED:
			updateDisplayBoardForHandicapped(spot);
			break;
		case COMPACT:
			updateDisplayBoardForCompact(spot);
			break;
		case LARGE:
			updateDisplayBoardForLarge(spot);
			break;
		case MOTORBIKE:
			updateDisplayBoardForMotorbike(spot);
			break;
		case ELECTRIC:
			updateDisplayBoardForElectric(spot);
			break;
		default:
			print("Wrong parking spot type!");
		}
	}

	private void updateDisplayBoardForElectric(ParkingSpot spot) {
		// TODO Auto-generated method stub

	}

	private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
		// TODO Auto-generated method stub

	}

	private void updateDisplayBoardForLarge(ParkingSpot spot) {
		// TODO Auto-generated method stub

	}

	private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
		
	}

	private void updateDisplayBoardForCompact(ParkingSpot spot) {
		
	}

	public void freeSpot(ParkingSpot spot) {
		spot.removeVehicle();
		switch (spot.getType()) {
		case HANDICAPPED:
			freeElectricSpotCount++;
			break;
		case COMPACT:
			freeCompactSpotCount++;
			break;
		case LARGE:
			freeLargeSpotCount++;
			break;
		case MOTORBIKE:
			freeMotorbikeSpotCount++;
			break;
		case ELECTRIC:
			freeElectricSpotCount++;
			break;
		default:
			print("Wrong parking spot type!");
		}
	}

	private void print(String s) {
		System.out.println(s);
	}

	static class ParkingFloorBuilder {
		
		private String name;
		private int freeElectricSpotCount;
		private int freeCompactSpotCount;
		private int freeLargeSpotCount;
		private int freeMotorbikeSpotCount;
		ParkingDisplayBoard displayBoard;

		public ParkingFloorBuilder setDisplayBoard(ParkingDisplayBoard displayBoard) {
			this.displayBoard = displayBoard;
			return this;
		}

		public ParkingFloorBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ParkingFloorBuilder setFreeElectricSpotCount(int freeElectricSpotCount) {
			this.freeElectricSpotCount = freeElectricSpotCount;
			return this;
		}

		public ParkingFloorBuilder setFreeCompactSpotCount(int freeCompactSpotCount) {
			this.freeCompactSpotCount = freeCompactSpotCount;
			return this;
		}

		public ParkingFloorBuilder setFreeLargeSpotCount(int freeLargeSpotCount) {
			this.freeLargeSpotCount = freeLargeSpotCount;
			return this;
		}

		public ParkingFloorBuilder setFreeMotorbikeSpotCount(int freeMotorbikeSpotCount) {
			this.freeMotorbikeSpotCount = freeMotorbikeSpotCount;
			return this;
		}

		public ParkingFloor build() {
			return new ParkingFloor(this);
		}
	}

}