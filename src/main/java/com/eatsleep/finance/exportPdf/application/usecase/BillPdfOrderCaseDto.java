package com.eatsleep.finance.exportPdf.application.usecase;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
public record BillPdfOrderCaseDto(
        UUID id,
        LocalDate createdAt,
        BigDecimal totalPrice,
        BigDecimal discountPercentage,
        String restaurantName,
        String customerName,
        String customerCui,
        List<BillPdfOrderDetailsCaseDto> details
) {


}
