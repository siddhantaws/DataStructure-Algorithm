package com.wfs.design.lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wfs.design.constant.PaymentType;
import com.wfs.design.constant.VehicleType;
import com.wfs.design.exception.ParkingFullException;
import com.wfs.design.payment.CreditCardPaymentStatergy;
import com.wfs.design.payment.DebitCardPaymentStatergy;
import com.wfs.design.payment.NetbankingPaymentStatergy;
import com.wfs.design.payment.PaymentGateway;
import com.wfs.design.payment.PaymentStatergy;
import com.wfs.design.vechile.Vehicle;

public class ParkingLot {
  private String name;
  private int compactSpotCount=0;
  private int largeSpotCount=0;
  private int motorbikeSpotCount=0;
  private int electricSpotCount=0;
  private final int maxCompactCount=0;
  private final int maxLargeCount=0;
  private final int maxMotorbikeCount=0;
  private final int maxElectricCount=0;
  private PaymentGateway gateway;
  private HashMap<String, EntrancePanel> entrancePanels=new HashMap<>();
  private HashMap<String, ExitPanel> exitPanels=new HashMap<>();
  private HashMap<String, ParkingFloor> parkingFloors =new HashMap<>();

  // all active parking tickets, identified by their ticketNumber
  private HashMap<String, ParkingTicket> activeTickets =new HashMap<>();

  // singleton ParkingLot to ensure only one object of ParkingLot in the system,
  // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
  // similarly exit panels will also use this object to close parking tickets
  private static ParkingLot parkingLot = null;

  private static int PARKING_FLOOR_COUNT =5;
  
  private static int ENTRANCE_PANNEL_COUNT=5;
  
  private static int EXIT_PANNEL_COUNT=5;
  // private constructor to restrict for singleton
  private ParkingLot() {
    // 1. initialize variables: read name, address and parkingRate from database
    // 2. initialize parking floors: read the parking floor map from database,
    //  this map should tell how many parking spots are there on each floor. This
    //  should also initialize max spot counts too.
    // 3. initialize parking spot counts by reading all active tickets from database
    // 4. initialize entrance and exit panels: read from database
	initializePaymnetGatewayAndStategy();
	initializeparkingFloor(PARKING_FLOOR_COUNT);
	initializeEntrancePannel(ENTRANCE_PANNEL_COUNT);
	initializeExitPannel(EXIT_PANNEL_COUNT);
  }

  public void initializePaymnetGatewayAndStategy() {
	  List<PaymentStatergy> list =new ArrayList();
	  for(PaymentType type :PaymentType.values()) {
		  switch(type) {
		  	case CREDIT_CARD:
		  		list.add(new CreditCardPaymentStatergy()); 	
		  		break;
		  	case NETBANKING:
		  		list.add(new NetbankingPaymentStatergy()); 	
		  		break;
		  	case DEBIT_CARD:
		  		list.add(new DebitCardPaymentStatergy()); 	
		  		break;
		  }
	  }
	  this.gateway =new PaymentGateway(list);
  }
  
  private void initializeEntrancePannel(int n) {
	  while(n>0) {
		  String pannel ="ENT-"+n;
		  EntrancePanel floor =new EntrancePanel(pannel,this);
		  entrancePanels.put(pannel, floor);
		  n--;
	  }
  }
  
  private void initializeExitPannel(int n) {
	  while(n>0) {
		  String pannelName ="EXIT-"+n;
		  ExitPanel panel =new ExitPanel(pannelName,this,gateway);
		  exitPanels.put(pannelName, panel);
		  n--;
	  }
  }
  
  private void initializeparkingFloor(int n) {
	  while(n>0) {
		  String floorName ="Floor-"+n;
		  ParkingFloor.ParkingFloorBuilder builder =new ParkingFloor.ParkingFloorBuilder();
		  ParkingFloor floor  = builder.setName(floorName).setFreeCompactSpotCount(10).setFreeElectricSpotCount(20).setFreeLargeSpotCount(30).setFreeMotorbikeSpotCount(40).
				  setDisplayBoard(new ParkingDisplayBoard()).build();
		  parkingFloors.put(floorName, floor);
		  n--;
	  }
  }
  
  
  public void processParkingTicket(ParkingTicket parkingTicket) {
	  
  }
  
  // static method to get the singleton instance of StockExchange
  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  // note that the following method is 'synchronized' to allow multiple entrances
  // panels to issue a new parking ticket without interfering with each other
  public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
    if (this.isFull(vehicle.getType())) {
      throw new ParkingFullException();
    }
    ParkingTicket ticket = new ParkingTicket();
    vehicle.assignTicket(ticket);
    // if the ticket is successfully saved in the database, we can increment the parking spot count
    this.incrementSpotCount(vehicle.getType());
    this.activeTickets.put(ticket.getTokenNumber(), ticket);
    return ticket;
  }

  public boolean isFull(VehicleType type) {
    // trucks and vans can only be parked in LargeSpot
    if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
      return largeSpotCount >= maxLargeCount;
    }

    // motorbikes can only be parked at motorbike spots
    if (type == VehicleType.MOTORBIKE) {
      return motorbikeSpotCount >= maxMotorbikeCount;
    }

    // cars can be parked at compact or large spots
    if (type == VehicleType.CAR) {
      return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
    }

    // electric car can be parked at compact, large or electric spots
    return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
        + maxElectricCount);
  }

  // increment the parking spot count based on the vehicle type
  private boolean incrementSpotCount(VehicleType type) {
    if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
      largeSpotCount++;
    } else if (type == VehicleType.MOTORBIKE) {
      motorbikeSpotCount++;
    } else if (type == VehicleType.CAR) {
      if (compactSpotCount < maxCompactCount) {
        compactSpotCount++;
      } else {
        largeSpotCount++;
      }
    } else { // electric car
      if (electricSpotCount < maxElectricCount) {
        electricSpotCount++;
      } else if (compactSpotCount < maxCompactCount) {
        compactSpotCount++;
      } else {
        largeSpotCount++;
      }
    }
	return false;
  }

 /* public boolean isFull() {
    for (String key : parkingFloors.keySet()) {
      if (!parkingFloors.get(key).isFull()) {
        return false;
      }
    }
    return true;
  }*/

  public void addParkingFloor(ParkingFloor floor) {
    /* stores in database */ }

  public void addEntrancePanel(EntrancePanel entrancePanel) {
    /* stores in database */ }

  public void addExitPanel(ExitPanel exitPanel) {
    /* stores in database */ }
}