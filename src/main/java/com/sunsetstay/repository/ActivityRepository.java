package com.sunsetstay.repository;

import com.sunsetstay.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query(
            value =
                    "select a.* from activity a inner join itinerary i on i.id_activity =a.id_activity inner join reservations r on r.id_reservation =i.id_reservation   where r.id_reservation = :idReservation",
            nativeQuery = true)
    List<Activity> listActivityByReservation(Integer idReservation);


}
