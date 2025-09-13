package com.eatsleep.finance.bill.application.ports.output;

import com.eatsleep.finance.bill.domain.ReservationDomainEntity;

import java.util.UUID;

public interface PayingReservationOutputPort {
    ReservationDomainEntity payingReservation(UUID reservationId);
}
