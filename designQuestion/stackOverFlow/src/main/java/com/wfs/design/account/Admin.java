package com.wfs.design.account;

import com.wfs.design.constant.AccountType;

public class Admin extends Member {


  public Admin() {
    super(AccountType.ADMIN);
  }

  public boolean blockMember(Member member){

  }
  public boolean unblockMember(Member member){

  }
}