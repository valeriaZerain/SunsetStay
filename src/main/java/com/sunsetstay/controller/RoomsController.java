package com.sunsetstay.controller;

import com.sunsetstay.dto.RoomDto;
import com.sunsetstay.entities.Room;
import com.sunsetstay.services.RoomService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

  private RoomService roomService;

  public RoomsController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("/list")
  public List<RoomDto> getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/available")
  public List<RoomDto> getAvailableRooms(
      @RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateCheckIn,
      @RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate dateCheckOut) {
    return roomService.getAvailableRooms(dateCheckIn,dateCheckOut);
  }
}
