package com.sunsetstay.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/** DTO for {@link com.sunsetstay.entities.Activity} */
public class ActivityDto implements Serializable {
  private final Integer id;
  private final LocalDate date;
  private final LocalTime startHour;
  private final LocalTime endHour;
  private final String description;
  private final String nameActivity;

  public ActivityDto(
      Integer id,
      LocalDate date,
      LocalTime startHour,
      LocalTime endHour,
      String description,
      String nameActivity) {
    this.id = id;
    this.date = date;
    this.startHour = startHour;
    this.endHour = endHour;
    this.description = description;
    this.nameActivity = nameActivity;
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getStartHour() {
    return startHour;
  }

  public LocalTime getEndHour() {
    return endHour;
  }

  public String getDescription() {
    return description;
  }

  public String getNameActivity() {
    return nameActivity;
  }
}
