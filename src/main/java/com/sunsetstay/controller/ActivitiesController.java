package com.sunsetstay.controller;

import com.sunsetstay.dto.ActivityDto;
import com.sunsetstay.entities.Activity;
import com.sunsetstay.services.ActivitiesService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

  private ActivitiesService activitiesService;

  public ActivitiesController(ActivitiesService activitiesService) {
    this.activitiesService = activitiesService;
  }

  @GetMapping("/list")
  public List<ActivityDto> getActivity() {
    return activitiesService.listActivities();
  }

  @GetMapping("/itinenary/{idReservation}")
  public List<ActivityDto> getActivityItinerary(@PathVariable Integer idReservation) {
    return activitiesService.listActivitiesItinerary(idReservation);
  }
}
