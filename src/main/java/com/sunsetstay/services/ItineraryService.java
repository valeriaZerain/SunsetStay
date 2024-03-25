package com.sunsetstay.services;

import com.sunsetstay.controller.request.ItineraryRequest;
import com.sunsetstay.entities.Itinerary;

public interface ItineraryService {
    Itinerary itineraryRegister(ItineraryRequest itineraryRequest);
}
