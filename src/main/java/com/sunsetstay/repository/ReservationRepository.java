package com.sunsetstay.repository;

import com.sunsetstay.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation findReservationById(Integer idReservation);

    @Query("SELECT r FROM Reservation r WHERE r.checkIn = ?1")
    List<Reservation> findReservationByDateCheckin(LocalDate checkIn);
}
