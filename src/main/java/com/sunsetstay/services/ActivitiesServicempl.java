package com.sunsetstay.services;

import com.sunsetstay.dto.ActivityDto;
import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.entities.Activity;
import com.sunsetstay.entities.Client;
import com.sunsetstay.mapper.ActivityMapper;
import com.sunsetstay.repository.ActivityRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ActivitiesServicempl implements ActivitiesService {

  private ActivityRepository activityRepository;

  private ActivityMapper activityMapper;

  public ActivitiesServicempl(
      ActivityRepository activityRepository, ActivityMapper activityMapper) {
    this.activityRepository = activityRepository;
    this.activityMapper = activityMapper;
  }

  @Override
  public List<ActivityDto> listActivities() {
    List<Activity> clientList = activityRepository.findAll();
    List<ActivityDto> activityDtoList =
        clientList.stream()
            .map(activity -> activityMapper.toDto(activity))
            .collect(Collectors.toList());
    return activityDtoList;
  }

  @Override
  public List<ActivityDto> listActivitiesItinerary(Integer idReservartion) {
    List<Activity> clientList = activityRepository.listActivityByReservation(idReservartion);
    List<ActivityDto> activityDtoList =
        clientList.stream()
            .map(activity -> activityMapper.toDto(activity))
            .collect(Collectors.toList());
    return activityDtoList;
  }
}
