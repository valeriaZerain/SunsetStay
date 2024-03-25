package com.sunsetstay.services;

import com.sunsetstay.dto.RoomDto;
import com.sunsetstay.entities.Room;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoomService {

    List<RoomDto> getRooms();

    List<RoomDto> getAvailableRooms(LocalDate dateCheckIn,LocalDate dateCheckOut);
}
