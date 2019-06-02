package com.wfs.desgn.cinema;

public class City {
  private String name;
  private String state;
  private String zipCode;

  public City(){}

  public City(String name, String state, String zipCode) {
    this.name = name;
    this.state = state;
    this.zipCode = zipCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}