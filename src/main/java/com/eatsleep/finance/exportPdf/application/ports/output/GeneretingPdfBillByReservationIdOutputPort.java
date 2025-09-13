package com.eatsleep.finance.exportPdf.application.ports.output;

import com.eatsleep.finance.bill.domain.ReservationDomainEntity;
import com.eatsleep.finance.exportPdf.domain.BillReservationDomainEntity;
import org.springframework.core.io.ByteArrayResource;

import java.util.UUID;

public interface GeneretingPdfBillByReservationIdOutputPort {
    ByteArrayResource generatePdfBillByReservationId(BillReservationDomainEntity entity);

}
