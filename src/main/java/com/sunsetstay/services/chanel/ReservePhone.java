package com.sunsetstay.services.chanel;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.entities.Room;
import com.sunsetstay.services.reserv.BasicRoomReserv;
import com.sunsetstay.services.reserv.PremiumRoomReserv;
import com.sunsetstay.services.reserv.RoomReservProcess;
import com.sunsetstay.services.reserv.SuiteRoomReserv;

public class ReservePhone implements ReservationChanelRoom {
  @Override
  public Reservation reserveRoom(Room room, Client client) {
    Reservation reservation=new Reservation();
    RoomReservProcess roomReservProcess=new RoomReservProcess();
    switch (room.getTypeRoom()){
      case "basic":
        roomReservProcess.setReserveStrategy(new BasicRoomReserv());
        break;
      case "premium":
        roomReservProcess.setReserveStrategy(new PremiumRoomReserv());
        break;
      case "suite":
        roomReservProcess.setReserveStrategy(new SuiteRoomReserv());
        break;
    }
    roomReservProcess.reserveRoom(room,client);
    reservation.setChanel(ChanelReserve.PHONE.toString());
    double pricePhone = room.getPrice()-(room.getPrice()*0.15);
    reservation.setTotalPrice(pricePhone);
    reservation.setState("confirm");
    System.out.println("Por tu reserva mediante telefono tienes un 15% de descuento");
    System.out.println(">>>> SMS de confirmacion enviado");
    return reservation;
  }
}
