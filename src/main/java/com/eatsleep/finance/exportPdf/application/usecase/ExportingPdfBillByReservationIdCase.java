package com.eatsleep.finance.exportPdf.application.usecase;

import com.eatsleep.finance.bill.application.ports.output.FindingBillByReservationIdOutputPort;
import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.common.application.annotations.UseCase;
import com.eatsleep.finance.common.infrastructure.exceptions.BadRequestException;
import com.eatsleep.finance.exportPdf.application.ports.input.ExportingPdfBillByReservationIdInputPort;
import com.eatsleep.finance.exportPdf.application.ports.output.GeneretingPdfBillByReservationIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.validation.annotation.Validated;


@UseCase
@Validated
@RequiredArgsConstructor
public class ExportingPdfBillByReservationIdCase implements ExportingPdfBillByReservationIdInputPort {

    private final GeneretingPdfBillByReservationIdOutputPort outputPort;
    private final FindingBillByReservationIdOutputPort findingBillByReservationIdOutputPort;

    @Override
    public ByteArrayResource exportPdfBillByReservationId(BillPdfReservationCaseDto billDto) {

        // buscar id en bill
        BillDomainEntity bill = findingBillByReservationIdOutputPort.findBillByReservationId(billDto.reservationId())
                .orElseThrow(()-> new BadRequestException("Reservacion sin generar pago"));

        return outputPort.generatePdfBillByReservationId(BillPdfReservationCaseDto.toDomainEntity(billDto, bill.getPaymentDate()));
    }
}
