package com.sunsetstay.services;

import com.sunsetstay.dto.ActivityDto;
import com.sunsetstay.entities.Activity;
import java.util.List;

public interface ActivitiesService {
    List<ActivityDto> listActivities();
    List<ActivityDto> listActivitiesItinerary(Integer idReservartion);
}
