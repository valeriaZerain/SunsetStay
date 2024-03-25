package com.sunsetstay.services.chanel;

import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.entities.Room;
import com.sunsetstay.services.reserv.BasicRoomReserv;
import com.sunsetstay.services.reserv.PremiumRoomReserv;
import com.sunsetstay.services.reserv.RoomReservProcess;
import com.sunsetstay.services.reserv.SuiteRoomReserv;

public class ReserveWhatsapp implements ReservationChanelRoom {
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
        reservation.setChanel(ChanelReserve.WHATSAPP.toString());
        double priceAIRBNB=room.getPrice()-(room.getPrice()*0.05);
        reservation.setTotalPrice(priceAIRBNB);
        reservation.setState("confirm");
        System.out.println("Por tu reserva mediante WhatsApp recibiste un 5% de descuento");
        System.out.println(">>>> Mensaje de confirmacion enviado a WhatsApp");
        return reservation;
    }
}
