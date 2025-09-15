package com.eatsleep.finance.exportPdf.application.ports.output;

import com.eatsleep.finance.exportPdf.application.usecase.BillPdfOrderCaseDto;
import org.springframework.core.io.ByteArrayResource;

public interface GeneretingPdfBillByOrderOutputPort {
    ByteArrayResource generatePdfBillOrder(BillPdfOrderCaseDto entity);
}
