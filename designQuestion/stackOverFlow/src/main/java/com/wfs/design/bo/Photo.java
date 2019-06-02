package com.wfs.design.bo;

import com.wfs.design.account.Member;

import java.util.Date;

public class Photo {
  private int photoId;
  private String photoPath;
  private Date creationDate;

  private Member creatingMember;

  public boolean delete(){
    return false;
  }

}