package com.eatsleep.finance.bill.application.ports.output;

import com.eatsleep.finance.bill.domain.BillDomainEntity;

import java.util.Optional;
import java.util.UUID;

public interface FindingBillByReservationIdOutputPort {
    Optional<BillDomainEntity> findBillByReservationId(UUID reservationId);
}
