package com.eatsleep.finance.bill.application.ports.input;

import com.eatsleep.finance.bill.domain.BillDomainEntity;

import java.util.UUID;

public interface FindingBillByReservationIdInputPort {
    BillDomainEntity findBillByReservationId(UUID reservationId);
}
