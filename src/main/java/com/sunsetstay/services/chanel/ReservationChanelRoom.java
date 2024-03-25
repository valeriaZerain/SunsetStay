package com.sunsetstay.services.chanel;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.entities.Room;

public interface ReservationChanelRoom {

    Reservation reserveRoom(Room room, Client client);
}
