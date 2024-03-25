package com.sunsetstay.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_room", nullable = false)
  private Integer id;

  @Column(name = "beds", nullable = false)
  private Integer beds;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "state", nullable = false, length = 100)
  private String state;

  @Column(name = "floor", nullable = false)
  private Integer floor;

  @Column(name = "type_room", length = 100)
  private String typeRoom;

  @OneToMany(mappedBy = "idRoom")
  @JsonIgnoreProperties("idRoom")
  private Set<Reservation> reservations = new LinkedHashSet<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBeds() {
    return beds;
  }

  public void setBeds(Integer beds) {
    this.beds = beds;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public String getTypeRoom() {
    return typeRoom;
  }

  public void setTypeRoom(String typeRoom) {
    this.typeRoom = typeRoom;
  }

  public Set<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(Set<Reservation> reservations) {
    this.reservations = reservations;
  }
}
