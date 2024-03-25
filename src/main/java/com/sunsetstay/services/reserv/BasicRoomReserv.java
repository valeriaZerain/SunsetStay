package com.sunsetstay.services.reserv;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;

public class BasicRoomReserv implements RoomReserveStrategy {

  @Override
  public void reserveRoom(Room room, Client client) {
    System.out.println("Realizaste una reserva básica, tienes acceso al desayuno buffett");
  }
}
