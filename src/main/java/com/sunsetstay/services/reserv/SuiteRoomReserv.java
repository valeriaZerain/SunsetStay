package com.sunsetstay.services.reserv;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;

public class SuiteRoomReserv implements RoomReserveStrategy {
  @Override
  public void reserveRoom(Room room, Client client) {
    System.out.println("Realizaste la reserva de un ahabitación suite, tienes acceso al desayuno buffett y a un masaje en el spa del hotel");
  }
}
