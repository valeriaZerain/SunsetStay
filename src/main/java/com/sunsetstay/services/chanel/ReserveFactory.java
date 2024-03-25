package com.sunsetstay.services.chanel;

import java.util.HashMap;
import java.util.Map;

public class ReserveFactory {

  private static final Map<ChanelReserve, ReservationChanelRoom> reservation =
      new HashMap<>() {
        {
          put(ChanelReserve.AIRBNB, new ReserveAirbnb());
          put(ChanelReserve.BOOKING, new ReserveBooking());
          put(ChanelReserve.EMAIL, new ReserveEmail());
          put(ChanelReserve.PHONE, new ReservePhone());
          put(ChanelReserve.WEB, new ReserveWeb());
          put(ChanelReserve.WHATSAPP, new ReserveWhatsapp());
        }
      };

  public ReservationChanelRoom reservRoom(ChanelReserve chanelReserve) {
    return reservation.get(chanelReserve);
  }
}
