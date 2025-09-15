package com.eatsleep.finance.exportPdf.application.ports.input;

import com.eatsleep.finance.exportPdf.application.usecase.BillPdfOrderCaseDto;
import org.springframework.core.io.ByteArrayResource;

public interface ExportingPdfBillByOrderInputPort {
    ByteArrayResource  exportPdfBillByOrder(BillPdfOrderCaseDto bill);
}
