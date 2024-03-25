package com.sunsetstay.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "itinerary")
public class Itinerary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_activity")
  @JsonIgnoreProperties("id_activity")
  private Activity idActivity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_reservation")
  @JsonIgnoreProperties("id_reservation")
  private Reservation idReservation;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Activity getIdActivity() {
    return idActivity;
  }

  public void setIdActivity(Activity idActivity) {
    this.idActivity = idActivity;
  }

  public Reservation getIdReservation() {
    return idReservation;
  }

  public void setIdReservation(Reservation idReservation) {
    this.idReservation = idReservation;
  }
}
