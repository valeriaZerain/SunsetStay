package com.sunsetstay.controller.request;

import com.sunsetstay.services.chanel.ChanelReserve;
import java.time.LocalDate;

public class ReservationRequest {

    private Integer idRoom;
    private Integer idClient;

    private ChanelReserve chanelReserve;

    private LocalDate checkIn;

    private LocalDate checkOut;

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public ChanelReserve getChanelReserve() {
        return chanelReserve;
    }

    public void setChanelReserve(ChanelReserve chanelReserve) {
        this.chanelReserve = chanelReserve;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
