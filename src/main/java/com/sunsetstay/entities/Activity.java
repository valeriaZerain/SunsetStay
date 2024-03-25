package com.sunsetstay.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "activity")
public class Activity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_activity", nullable = false)
  private Integer id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "start_hour", nullable = false)
  private LocalTime startHour;

  @Column(name = "end_hour", nullable = false)
  private LocalTime endHour;

  @Column(name = "description", nullable = false, length = 1000)
  private String description;

  @Column(name = "name_activity", nullable = false, length = 100)
  private String nameActivity;

  @OneToMany(mappedBy = "idActivity")
  @JsonIgnoreProperties("idActivity")
  private Set<Itinerary> itineraries = new LinkedHashSet<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getStartHour() {
    return startHour;
  }

  public void setStartHour(LocalTime startHour) {
    this.startHour = startHour;
  }

  public LocalTime getEndHour() {
    return endHour;
  }

  public void setEndHour(LocalTime endHour) {
    this.endHour = endHour;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNameActivity() {
    return nameActivity;
  }

  public void setNameActivity(String nameActivity) {
    this.nameActivity = nameActivity;
  }

  public Set<Itinerary> getItineraries() {
    return itineraries;
  }

  public void setItineraries(Set<Itinerary> itineraries) {
    this.itineraries = itineraries;
  }
}
