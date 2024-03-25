package com.sunsetstay.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_reservation", nullable = false)
  private Integer id;

  @Column(name = "check_in", nullable = false)
  private LocalDate checkIn;

  @Column(name = "check_out", nullable = false)
  private LocalDate checkOut;

  @Column(name = "total_price", nullable = false)
  private Double totalPrice;

  @Column(name = "state", nullable = false, length = 100)
  private String state;

  @Column(name = "chanel", length = 100)
  private String chanel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_client")
  @JsonIgnoreProperties("client")
  private Client idClient;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_room")
  @JsonIgnoreProperties("idRoom")
  private Room idRoom;

  @OneToMany(mappedBy = "idReservation")
  @JsonIgnoreProperties("idReservation")
  private Set<Itinerary> itineraries = new LinkedHashSet<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDate checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDate getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDate checkOut) {
    this.checkOut = checkOut;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getChanel() {
    return chanel;
  }

  public void setChanel(String chanel) {
    this.chanel = chanel;
  }

  public Client getIdClient() {
    return idClient;
  }

  public void setIdClient(Client idClient) {
    this.idClient = idClient;
  }

  public Room getIdRoom() {
    return idRoom;
  }

  public void setIdRoom(Room idRoom) {
    this.idRoom = idRoom;
  }

  public Set<Itinerary> getItineraries() {
    return itineraries;
  }

  public void setItineraries(Set<Itinerary> itineraries) {
    this.itineraries = itineraries;
  }
}
