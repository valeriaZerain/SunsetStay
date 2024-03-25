package com.sunsetstay.services.reserv;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;

public class RoomReservProcess {
    private RoomReserveStrategy reserveStrategy;

    public void setReserveStrategy(RoomReserveStrategy reserveStrategy) {
        this.reserveStrategy = reserveStrategy;
    }

    public void reserveRoom(Room room, Client client) {
        reserveStrategy.reserveRoom(room, client);
    }
}
