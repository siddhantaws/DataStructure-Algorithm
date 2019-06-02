package com.wfs.design.bo;

import com.wfs.design.account.Member;

import java.util.Date;
import java.util.List;

public class Answer {
  private String answerText;
  private boolean accepted;
  private int voteCount;
  private int flagCount;
  private Date creationTime;

  private Member creatingMember;
  private List<Photo> photos;

  public String getAnswerText() {
    return answerText;
  }

  public void setAnswerText(String answerText) {
    this.answerText = answerText;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  public int getFlagCount() {
    return flagCount;
  }

  public void setFlagCount(int flagCount) {
    this.flagCount = flagCount;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Member getCreatingMember() {
    return creatingMember;
  }

  public void setCreatingMember(Member creatingMember) {
    this.creatingMember = creatingMember;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }

  public boolean incrementVoteCount(){
    return true;
  }
}