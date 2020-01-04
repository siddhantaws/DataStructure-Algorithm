package com.wfs.design.account;
// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

import com.wfs.design.constant.AccountStatus;
import com.wfs.design.constant.Person;

public abstract class Account {
  private String string;
  private String password;
  private AccountStatus status;
  private Person person;

  public boolean resetPassword(){

  }

  public String getString() {
    return string;
  }

  public Account(AccountStatus status, Person person) {
    this.status = status;
    this.person = person;
  }

  public void setString(String string) {
    this.string = string;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public void setStatus(AccountStatus status) {
    this.status = status;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public static class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address(String streetAddress, String city, String state, String zipCode, String country) {
      this.streetAddress = streetAddress;
      this.city = city;
      this.state = state;
      this.zipCode = zipCode;
      this.country = country;
    }
    public Address(){}

    public String getStreetAddress() {
      return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
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

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }
  }
}

