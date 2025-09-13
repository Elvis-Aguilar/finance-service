package com.eatsleep.finance.bill.infrastructure.outputadapter.client.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder(toBuilder = true)
public record ReservationResponseDto(
        UUID id,
        UUID customerId,
        LocalDate startDate,
        LocalDate endDate,
        String state,
        BigDecimal pricePerDay,
        BigDecimal totalPrice,
        BigDecimal maintenanceCostPerDay,
        BigDecimal totalCost,
        BigDecimal discountPercentage,
        UUID roomId
) {
}
