package com.sunsetstay.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/** DTO for {@link com.sunsetstay.entities.Reservation} */
public class ReservationDto implements Serializable {
  private final Integer id;
  private final LocalDate checkIn;
  private final LocalDate checkOut;
  private final Double totalPrice;
  private final String chanel;
  private final RoomDto idRoom;

  public ReservationDto(
      Integer id,
      LocalDate checkIn,
      LocalDate checkOut,
      Double totalPrice,
      String chanel,
      RoomDto idRoom) {
    this.id = id;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.totalPrice = totalPrice;
    this.chanel = chanel;
    this.idRoom = idRoom;
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getCheckIn() {
    return checkIn;
  }

  public LocalDate getCheckOut() {
    return checkOut;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public String getChanel() {
    return chanel;
  }

  public RoomDto getIdRoom() {
    return idRoom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReservationDto entity = (ReservationDto) o;
    return Objects.equals(this.id, entity.id)
        && Objects.equals(this.checkIn, entity.checkIn)
        && Objects.equals(this.checkOut, entity.checkOut)
        && Objects.equals(this.totalPrice, entity.totalPrice)
        && Objects.equals(this.chanel, entity.chanel)
        && Objects.equals(this.idRoom, entity.idRoom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, checkIn, checkOut, totalPrice, chanel, idRoom);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
        + "("
        + "id = "
        + id
        + ", "
        + "checkIn = "
        + checkIn
        + ", "
        + "checkOut = "
        + checkOut
        + ", "
        + "totalPrice = "
        + totalPrice
        + ", "
        + "chanel = "
        + chanel
        + ", "
        + "idRoom = "
        + idRoom
        + ")";
  }
}
