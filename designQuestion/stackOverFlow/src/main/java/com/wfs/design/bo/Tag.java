package com.wfs.design.bo;

import com.wfs.design.constant.TagType;

public class Tag {

  private String name;
  private String description;
  private long dailyAskedFrequency;
  private long weeklyAskedFrequency;

  public Tag(TagType tagType) {
    this.name =tagType.name();
  }

  public Tag(String name, String description, long dailyAskedFrequency, long weeklyAskedFrequency) {
    this.name = name;
    this.description = description;
    this.dailyAskedFrequency = dailyAskedFrequency;
    this.weeklyAskedFrequency = weeklyAskedFrequency;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getDailyAskedFrequency() {
    return dailyAskedFrequency;
  }

  public void setDailyAskedFrequency(long dailyAskedFrequency) {
    this.dailyAskedFrequency = dailyAskedFrequency;
  }

  public long getWeeklyAskedFrequency() {
    return weeklyAskedFrequency;
  }

  public void setWeeklyAskedFrequency(long weeklyAskedFrequency) {
    this.weeklyAskedFrequency = weeklyAskedFrequency;
  }
}
