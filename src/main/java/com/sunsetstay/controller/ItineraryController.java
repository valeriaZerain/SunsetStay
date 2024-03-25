package com.sunsetstay.controller;

import com.sunsetstay.controller.request.ItineraryRequest;
import com.sunsetstay.entities.Itinerary;
import com.sunsetstay.services.ItineraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itinerary")
public class ItineraryController {

  private ItineraryService itineraryService;

  public ItineraryController(ItineraryService itineraryService) {
    this.itineraryService = itineraryService;
  }

  @PostMapping("/activity-register")
  public Itinerary saveItinerary(@RequestBody ItineraryRequest reservation) {
    return itineraryService.itineraryRegister(reservation);
  }
}
