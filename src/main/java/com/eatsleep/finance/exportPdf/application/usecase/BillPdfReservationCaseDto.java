package com.eatsleep.finance.exportPdf.application.usecase;

import com.eatsleep.finance.exportPdf.domain.BillReservationDomainEntity;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Builder(toBuilder = true)
public record BillPdfReservationCaseDto(
        UUID reservationId,
        LocalDate startDate,
        LocalDate endDate,
        String state,
        BigDecimal pricePerDay,
        BigDecimal totalPrice,
        BigDecimal discountPercentage,
        String roomNumber,
        String hotelName,
        String customerName,
        String customerCui
) {

    public static BillReservationDomainEntity toDomainEntity(BillPdfReservationCaseDto billDto, Instant paymentDate) {
        return new  BillReservationDomainEntity(
                billDto.reservationId(),
                billDto.customerName(),
                billDto.hotelName(),
                billDto.roomNumber(),
                billDto.discountPercentage(),
                billDto.totalPrice(),
                billDto.pricePerDay(),
                billDto.state(),
                billDto.startDate(),
                billDto.endDate(),
                billDto.customerCui(),
                paymentDate
        );
    }
}
