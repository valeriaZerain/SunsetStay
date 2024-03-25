package com.sunsetstay.services;

import com.sunsetstay.controller.request.ReservationRequest;
import com.sunsetstay.controller.response.ReservationResponse;
import com.sunsetstay.dto.ReservationDto;
import com.sunsetstay.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest reservationRequest);

    List<ReservationDto> listReservation();

    ReservationDto getReservationById(Integer id);

    List<ReservationDto> listReservationByDate(LocalDate checkin);
}