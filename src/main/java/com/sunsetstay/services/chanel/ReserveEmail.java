package com.sunsetstay.services.chanel;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.entities.Room;
import com.sunsetstay.services.reserv.BasicRoomReserv;
import com.sunsetstay.services.reserv.PremiumRoomReserv;
import com.sunsetstay.services.reserv.RoomReservProcess;
import com.sunsetstay.services.reserv.SuiteRoomReserv;

public class ReserveEmail implements ReservationChanelRoom {
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
        reservation.setChanel(ChanelReserve.EMAIL.toString());
        double priceEmail = room.getPrice()-(room.getPrice()*0.1);
        reservation.setTotalPrice(priceEmail);
        reservation.setState("confirm");
        System.out.println("Por tu reserva mediante email tienes un 10% de descuento");
        System.out.println(">>>> Email de confirmacion enviado");
        return reservation;
    }
}
