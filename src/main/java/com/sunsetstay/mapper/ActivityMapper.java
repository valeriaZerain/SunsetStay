package com.sunsetstay.mapper;

import com.sunsetstay.dto.ActivityDto;
import com.sunsetstay.entities.Activity;
import org.mapstruct.*;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {
  Activity toEntity(ActivityDto activityDto);

  ActivityDto toDto(Activity activity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Activity partialUpdate(ActivityDto activityDto, @MappingTarget Activity activity);
}
