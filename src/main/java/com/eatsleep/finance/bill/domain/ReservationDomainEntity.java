package com.eatsleep.finance.bill.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ReservationDomainEntity {

    private UUID id;
    private UUID customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private BigDecimal pricePerDay;
    private BigDecimal totalPrice;
    private BigDecimal maintenanceCostPerDay;
    private BigDecimal totalCost;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    private UUID roomId;

    public ReservationDomainEntity(UUID id, UUID customerId, LocalDate startDate, LocalDate endDate, String state, BigDecimal pricePerDay, BigDecimal totalPrice, BigDecimal maintenanceCostPerDay, BigDecimal totalCost, BigDecimal discountPercentage, UUID roomId, UUID promotionId) {
        this.id = id;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.pricePerDay = pricePerDay;
        this.totalPrice = totalPrice;
        this.maintenanceCostPerDay = maintenanceCostPerDay;
        this.totalCost = totalCost;
        this.discountPercentage = discountPercentage;
        this.roomId = roomId;
        this.promotionId = promotionId;
    }

}
