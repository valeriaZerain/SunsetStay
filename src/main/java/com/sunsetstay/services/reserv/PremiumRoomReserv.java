package com.sunsetstay.services.reserv;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;

public class PremiumRoomReserv implements RoomReserveStrategy{
    @Override
    public void reserveRoom(Room room, Client client) {
        System.out.println("Reservaste una habitación premium, tienes acceso a nuestras instalaciones VIP, al desayuno, almuerzo y cena");
    }
}
