package com.wfs.design.lot;
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

  public abstract boolean resetPassword();
}

