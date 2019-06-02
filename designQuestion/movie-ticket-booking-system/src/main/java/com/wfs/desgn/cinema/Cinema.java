package com.wfs.desgn.cinema;

import com.wfs.desgn.address.Address;

import java.util.List;

public class Cinema {
  private String name;
  private int totalCinemaHalls;
  private Address location;

  private List<CinemaHall> halls;

  public Cinema(String name, int totalCinemaHalls, Address location, List<CinemaHall> halls) {
    this.name = name;
    this.totalCinemaHalls = totalCinemaHalls;
    this.location = location;
    this.halls = halls;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTotalCinemaHalls() {
    return totalCinemaHalls;
  }

  public void setTotalCinemaHalls(int totalCinemaHalls) {
    this.totalCinemaHalls = totalCinemaHalls;
  }

  public Address getLocation() {
    return location;
  }

  public void setLocation(Address location) {
    this.location = location;
  }

  public List<CinemaHall> getHalls() {
    return halls;
  }

  public void setHalls(List<CinemaHall> halls) {
    this.halls = halls;
  }
}