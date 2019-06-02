package com.wfs.design.bo;

import com.wfs.design.account.Member;

import java.util.Date;

public class Comment {
  private String text;
  private Date creationTime;

  private int flagCount;

  private int voteCount;

  private Member askingMember;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public int getFlagCount() {
    return flagCount;
  }

  public void setFlagCount(int flagCount) {
    this.flagCount = flagCount;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  public Member getAskingMember() {
    return askingMember;
  }

  public void setAskingMember(Member askingMember) {
    this.askingMember = askingMember;
  }

  public boolean incrementVoteCount(){
    voteCount++;
    return true;
  }
}