package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record EmployeesResponseDto(
        UUID id,
        String email,
        String fullName,
        String cui,
        String phone,
        String jobPosition,
        BigDecimal salary,
        String address,
        String jobArea,
        UUID hotelId,
        UUID restaurantId
) {
}
