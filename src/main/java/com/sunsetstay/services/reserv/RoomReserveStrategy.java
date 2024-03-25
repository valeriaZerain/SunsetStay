package com.sunsetstay.services.reserv;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;

public interface RoomReserveStrategy {
  void reserveRoom(Room room, Client client);
}
