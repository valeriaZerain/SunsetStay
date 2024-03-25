package com.sunsetstay.services;

import com.sunsetstay.controller.request.ReservationRequest;
import com.sunsetstay.controller.response.ReservationResponse;
import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.dto.ReservationDto;
import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.entities.Room;
import com.sunsetstay.mapper.ReservationMapper;
import com.sunsetstay.repository.ClientRepository;
import com.sunsetstay.repository.ReservationRepository;
import com.sunsetstay.repository.RoomsRepository;
import com.sunsetstay.services.chanel.ReservationChanelRoom;
import com.sunsetstay.services.chanel.ReserveFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
  private ReservationRepository reservationRepository;
  private RoomsRepository roomsRepository;
  private ClientRepository clientRepository;

  private ReservationMapper reservationMapper;

  public ReservationServiceImpl(
      ReservationRepository reservationRepository,
      RoomsRepository roomsRepository,
      ClientRepository clientRepository,
      ReservationMapper reservationMapper) {
    this.reservationRepository = reservationRepository;
    this.roomsRepository = roomsRepository;
    this.clientRepository = clientRepository;
    this.reservationMapper = reservationMapper;
  }

  @Override
  public ReservationResponse createReservation(ReservationRequest reservationRequest) {
    ReservationResponse response = new ReservationResponse();
    Room room = roomsRepository.findById(reservationRequest.getIdRoom()).get();
    Client client = clientRepository.findById(reservationRequest.getIdClient()).get();

    ReserveFactory reserveFactory = new ReserveFactory();
    ReservationChanelRoom reservationChanelRoom =
        reserveFactory.reservRoom(reservationRequest.getChanelReserve());
    Reservation reservation = reservationChanelRoom.reserveRoom(room, client);
    reservation.setIdRoom(room);
    reservation.setIdClient(client);
    reservation.setCheckIn(reservationRequest.getCheckIn());
    reservation.setCheckOut(reservationRequest.getCheckOut());
    reservation = reservationRepository.save(reservation);
    if (reservation.getId() != null) {
      response.setIdReservation(reservation.getId());
      response.setMessage(
          String.format(
              "Se reservo la habitacion %s con el codigo de reserva: %d",
              reservationMapper.toDto(reservation).toString(), reservation.getId()));
    } else {
      response.setMessage(
          String.format(
              "No se pudo reservar la habitacion %s",
              reservationMapper.toDto(reservation).toString()));
    }
    return response;
  }

  @Override
  public List<ReservationDto> listReservation() {
    List<Reservation> reservationList = reservationRepository.findAll();
    List<ReservationDto> reservationDtos =
        reservationList.stream()
            .map(reservation -> reservationMapper.toDto(reservation))
            .collect(Collectors.toList());
    return reservationDtos;
  }

  @Override
  public ReservationDto getReservationById(Integer id) {
    Reservation reservation = reservationRepository.findById(id).get();
    ReservationDto responseDto = reservationMapper.toDto(reservation);
    return responseDto;
  }

  @Override
  public List<ReservationDto> listReservationByDate(LocalDate checkin) {
    List<Reservation> reservationList = reservationRepository.findReservationByDateCheckin(checkin);
    List<ReservationDto> reservationDtos =
        reservationList.stream()
            .map(reservation -> reservationMapper.toDto(reservation))
            .collect(Collectors.toList());
    return reservationDtos;
  }
}
