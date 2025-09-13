package com.eatsleep.finance.exportPdf.application.ports.input;

import com.eatsleep.finance.exportPdf.application.usecase.BillPdfReservationCaseDto;
import org.springframework.core.io.ByteArrayResource;

import java.util.UUID;

public interface ExportingPdfBillByReservationIdInputPort {
    ByteArrayResource  exportPdfBillByReservationId(BillPdfReservationCaseDto bill);
}
