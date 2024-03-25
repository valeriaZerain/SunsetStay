package com.sunsetstay.mapper;

import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.dto.ReservationDto;
import com.sunsetstay.entities.Client;
import com.sunsetstay.entities.Reservation;
import org.mapstruct.*;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
  Reservation toEntity(ReservationDto reservationDto);

  ReservationDto toDto(Reservation reservation);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Reservation partialUpdate(ReservationDto reservationDto, @MappingTarget Reservation reservation);

}
