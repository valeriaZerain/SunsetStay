package com.sunsetstay.services;

import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.dto.RoomDto;
import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Room;
import com.sunsetstay.mapper.RoomMapper;
import com.sunsetstay.repository.RoomsRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

  private RoomsRepository roomsRepository;

  private RoomMapper roomMapper;

  public RoomServiceImpl(RoomsRepository roomsRepository, RoomMapper roomMapper) {
    this.roomsRepository = roomsRepository;
    this.roomMapper = roomMapper;
  }

  @Override
  public List<RoomDto> getRooms() {
    List<Room> roomList = roomsRepository.findAll();
    List<RoomDto> roomDtoList =
        roomList.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    return roomDtoList;
  }

  @Override
  public List<RoomDto> getAvailableRooms(LocalDate dateCheckIn,LocalDate dateCheckOut) {
    List<Room> roomList = roomsRepository.findAllRoomsAvailable(dateCheckIn,dateCheckOut);
    List<RoomDto> roomDtoList =
            roomList.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    return roomDtoList;
  }
}
