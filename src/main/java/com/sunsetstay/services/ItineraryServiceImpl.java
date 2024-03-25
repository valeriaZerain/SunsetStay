package com.sunsetstay.services;

import com.sunsetstay.controller.request.ItineraryRequest;
import com.sunsetstay.entities.Activity;
import com.sunsetstay.entities.Itinerary;
import com.sunsetstay.entities.Reservation;
import com.sunsetstay.repository.ActivityRepository;
import com.sunsetstay.repository.ItineraryRepository;
import com.sunsetstay.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements ItineraryService {

  private ItineraryRepository itineraryRepository;

  private ReservationRepository reservationRepository;

  private ActivityRepository activityRepository;

  public ItineraryServiceImpl(
      ItineraryRepository itineraryRepository,
      ReservationRepository reservationRepository,
      ActivityRepository activityRepository) {
    this.itineraryRepository = itineraryRepository;
    this.reservationRepository = reservationRepository;
    this.activityRepository = activityRepository;
  }

  @Override
  public Itinerary itineraryRegister(ItineraryRequest itineraryRequest) {
    Itinerary itinerary = new Itinerary();
    Reservation reservation =
        reservationRepository.findById(itineraryRequest.getIdReservation()).get();
    Activity activity = activityRepository.findById(itineraryRequest.getIdActivity()).get();
    itinerary.setIdActivity(activity);
    itinerary.setIdReservation(reservation);
    return itineraryRepository.save(itinerary);
  }
}
