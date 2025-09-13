package com.eatsleep.finance.exportPdf.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class BillReservationDomainEntity {
    private UUID reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private BigDecimal pricePerDay;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private String roomNumber;
    private String hotelName;
    private String customerName;
    private String customerCui;
    private Instant paymentDate;

    public BillReservationDomainEntity(UUID reservationId, String customerName, String hotelName, String roomNumber, BigDecimal discountPercentage, BigDecimal totalPrice, BigDecimal pricePerDay, String state, LocalDate endDate, LocalDate startDate,  String customerCui, Instant paymentDate) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.hotelName = hotelName;
        this.roomNumber = roomNumber;
        this.discountPercentage = discountPercentage;
        this.totalPrice = totalPrice;
        this.pricePerDay = pricePerDay;
        this.state = state;
        this.endDate = endDate;
        this.startDate = startDate;
        this.customerCui = customerCui;
        this.paymentDate = paymentDate;
    }
}
