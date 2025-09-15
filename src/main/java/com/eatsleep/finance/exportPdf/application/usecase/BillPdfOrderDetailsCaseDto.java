package com.eatsleep.finance.exportPdf.application.usecase;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
public record BillPdfOrderDetailsCaseDto(
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal unitCost,
        BigDecimal subtotal,
        BigDecimal discountPercentage,
        String dishName
) {


}
