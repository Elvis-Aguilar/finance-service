package com.eatsleep.finance.exportPdf.application.usecase;

import com.eatsleep.finance.bill.application.ports.output.FindingBillByOrderIdOutputPort;
import com.eatsleep.finance.bill.application.ports.output.FindingBillByReservationIdOutputPort;
import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.common.application.annotations.UseCase;
import com.eatsleep.finance.common.infrastructure.exceptions.BadRequestException;
import com.eatsleep.finance.exportPdf.application.ports.input.ExportingPdfBillByOrderInputPort;
import com.eatsleep.finance.exportPdf.application.ports.input.ExportingPdfBillByReservationIdInputPort;
import com.eatsleep.finance.exportPdf.application.ports.output.GeneretingPdfBillByOrderOutputPort;
import com.eatsleep.finance.exportPdf.application.ports.output.GeneretingPdfBillByReservationIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.validation.annotation.Validated;


@UseCase
@Validated
@RequiredArgsConstructor
public class ExportingPdfBillByOrderIdCase implements ExportingPdfBillByOrderInputPort {

    private final FindingBillByOrderIdOutputPort findingBillByOrderIdOutputPort;
    private final GeneretingPdfBillByOrderOutputPort generatingPdfBillByOrderOutputPort;


    @Override
    public ByteArrayResource exportPdfBillByOrder(BillPdfOrderCaseDto billDto) {

        // buscar id en bill
        BillDomainEntity bill = findingBillByOrderIdOutputPort.findBillByOrderId(billDto.id())
                .orElseThrow(()-> new BadRequestException("Orden sin generar pago"));

        return generatingPdfBillByOrderOutputPort.generatePdfBillOrder(billDto);
    }
}
