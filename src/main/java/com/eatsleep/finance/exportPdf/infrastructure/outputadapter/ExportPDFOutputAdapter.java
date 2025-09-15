package com.eatsleep.finance.exportPdf.infrastructure.outputadapter;

import com.eatsleep.finance.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.finance.exportPdf.application.ports.output.GeneretingPdfBillByOrderOutputPort;
import com.eatsleep.finance.exportPdf.application.ports.output.GeneretingPdfBillByReservationIdOutputPort;
import com.eatsleep.finance.exportPdf.application.usecase.BillPdfOrderCaseDto;
import com.eatsleep.finance.exportPdf.domain.BillReservationDomainEntity;
import com.eatsleep.finance.exportPdf.infrastructure.outputadapter.pdfGeneror.ExportPdf;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExportPDFOutputAdapter implements GeneretingPdfBillByReservationIdOutputPort, GeneretingPdfBillByOrderOutputPort {

    private final ExportPdf exportPdf;

    @Override
    public ByteArrayResource generatePdfBillByReservationId(BillReservationDomainEntity entity) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("bill", entity);
        templateVariables.put("dateGereneration", LocalDate.now());
        long days = ChronoUnit.DAYS.between(entity.getStartDate(), entity.getEndDate()) + 1;
        templateVariables.put("days", days);
        return exportPdf.downloadPdf("bill-reservation", templateVariables);
    }

    @Override
    public ByteArrayResource generatePdfBillOrder(BillPdfOrderCaseDto entity) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("dateGereneration", LocalDate.now());
        templateVariables.put("bill", entity);
        return exportPdf.downloadPdf("bill-order", templateVariables);
    }
}
