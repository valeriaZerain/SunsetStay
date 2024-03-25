package com.sunsetstay.controller;

import com.sunsetstay.controller.request.ReservationRequest;
import com.sunsetstay.controller.response.ReservationResponse;
import com.sunsetstay.dto.ReservationDto;
import com.sunsetstay.dto.RoomDto;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.services.ReservationService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
  private ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping("/room")
  public ReservationResponse saveReservation(@RequestBody ReservationRequest reservation) {
    return reservationService.createReservation(reservation);
  }

  @GetMapping("/list")
  public List<ReservationDto> getClientByCi() {
    return reservationService.listReservation();
  }

  @GetMapping("/{id}")
  public ReservationDto getReservationById(@PathVariable Integer id) {
    return reservationService.getReservationById(id);
  }

  @GetMapping("/reservations")
  public List<ReservationDto> getReservationByDate(
      @RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate dateCheckIn) {
    return reservationService.listReservationByDate(dateCheckIn);
  }
}
