package com.sunsetstay.repository;

import com.sunsetstay.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Room, Integer> {

  @Query(
      value =
          "select * from rooms where id_room not in (select r.id_room from rooms r left outer join reservations r2 on r2.id_room =r.id_room where r2.check_in  between :dateCheckIn and :dateCheckOut) ",
      nativeQuery = true)
  List<Room> findAllRoomsAvailable(LocalDate dateCheckIn, LocalDate dateCheckOut);
}
