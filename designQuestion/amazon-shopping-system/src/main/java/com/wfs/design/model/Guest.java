package com.wfs.design.model;

import com.wfs.design.constant.CustomerType;

public class Guest extends Customer {

  public Guest() {
    super(CustomerType.GUEST);
  }

  public boolean isRegisterAccount(){
    return false;
  }
}
