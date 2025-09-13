package com.eatsleep.finance.exportPdf.infrastructure.inputadapter.dto;

import com.eatsleep.finance.exportPdf.application.usecase.BillPdfReservationCaseDto;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder(toBuilder = true)
public record BillReservationRequestDto (
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
){

    public static BillPdfReservationCaseDto toCase(BillReservationRequestDto dto){
        return BillPdfReservationCaseDto.builder()
                .reservationId(dto.reservationId())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .state(dto.state())
                .pricePerDay(dto.pricePerDay())
                .totalPrice(dto.totalPrice())
                .discountPercentage(dto.discountPercentage())
                .roomNumber(dto.roomNumber())
                .hotelName(dto.hotelName())
                .customerName(dto.customerName())
                .customerCui(dto.customerCui())
                .build();
    }
}
