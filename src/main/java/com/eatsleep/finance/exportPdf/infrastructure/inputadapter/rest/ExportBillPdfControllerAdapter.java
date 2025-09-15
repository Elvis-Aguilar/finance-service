package com.eatsleep.finance.exportPdf.infrastructure.inputadapter.rest;

import com.eatsleep.finance.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.finance.exportPdf.application.ports.input.ExportingPdfBillByOrderInputPort;
import com.eatsleep.finance.exportPdf.application.ports.input.ExportingPdfBillByReservationIdInputPort;
import com.eatsleep.finance.exportPdf.application.usecase.BillPdfOrderCaseDto;
import com.eatsleep.finance.exportPdf.application.usecase.BillPdfReservationCaseDto;
import com.eatsleep.finance.exportPdf.infrastructure.inputadapter.dto.BillReservationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("v1/exports")
@WebAdapter
@RequiredArgsConstructor
public class ExportBillPdfControllerAdapter {

    private final ExportingPdfBillByReservationIdInputPort exportingPdfBillByReservationIdInputPort;
    private final ExportingPdfBillByOrderInputPort exportingPdfBillByOrderInputPort;

    @PostMapping("/bill/reservation")
    public ResponseEntity<Resource> exportBillReservation(@RequestBody BillReservationRequestDto bill){

        BillPdfReservationCaseDto dto = BillReservationRequestDto.toCase(bill);

        ByteArrayResource resource = exportingPdfBillByReservationIdInputPort.exportPdfBillByReservationId(dto);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                        .filename("bill-reservation.pdf")
                        .build()
                        .toString())
                .body(resource);
    }

    @PostMapping("/bill/order")
    public ResponseEntity<Resource> exportBillOrder(@RequestBody BillPdfOrderCaseDto bill){

        ByteArrayResource resource = exportingPdfBillByOrderInputPort.exportPdfBillByOrder(bill);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                        .filename("bill-order.pdf")
                        .build()
                        .toString())
                .body(resource);
    }


}
