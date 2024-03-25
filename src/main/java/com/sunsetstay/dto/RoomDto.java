package com.sunsetstay.dto;

import java.io.Serializable;
import java.util.Objects;

/** DTO for {@link com.sunsetstay.entities.Room} */
public class RoomDto implements Serializable {
  private final Integer id;
  private final Integer beds;
  private final Double price;
  private final String state;
  private final Integer floor;
  private final String typeRoom;

  public RoomDto(
      Integer id, Integer beds, Double price, String state, Integer floor, String typeRoom) {
    this.id = id;
    this.beds = beds;
    this.price = price;
    this.state = state;
    this.floor = floor;
    this.typeRoom = typeRoom;
  }

  public Integer getId() {
    return id;
  }

  public Integer getBeds() {
    return beds;
  }

  public Double getPrice() {
    return price;
  }

  public String getState() {
    return state;
  }

  public Integer getFloor() {
    return floor;
  }

  public String getTypeRoom() {
    return typeRoom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoomDto entity = (RoomDto) o;
    return Objects.equals(this.id, entity.id)
        && Objects.equals(this.beds, entity.beds)
        && Objects.equals(this.price, entity.price)
        && Objects.equals(this.state, entity.state)
        && Objects.equals(this.floor, entity.floor)
        && Objects.equals(this.typeRoom, entity.typeRoom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, beds, price, state, floor, typeRoom);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
        + "("
        + "id = "
        + id
        + ", "
        + "beds = "
        + beds
        + ", "
        + "price = "
        + price
        + ", "
        + "state = "
        + state
        + ", "
        + "floor = "
        + floor
        + ", "
        + "typeRoom = "
        + typeRoom
        + ")";
  }
}
