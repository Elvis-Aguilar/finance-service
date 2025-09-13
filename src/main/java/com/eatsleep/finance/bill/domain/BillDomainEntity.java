package com.eatsleep.finance.bill.domain;

import com.eatsleep.finance.common.infrastructure.exceptions.BadRequestException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class BillDomainEntity {
    private UUID id;
    private BigDecimal amount;
    private String paymentMethod = "TARJETA";
    private UUID reservationId;
    private UUID orderId;
    private Instant paymentDate;

    public BillDomainEntity(UUID id, BigDecimal amount, UUID reservationId, UUID orderId, Instant paymentDate) {
        this.id = id;
        this.amount = amount;
        this.reservationId = reservationId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.validate();

    }

    public BillDomainEntity(BigDecimal amount, UUID reservationId, UUID orderId) {
        this.amount = amount;
        this.reservationId = reservationId;
        this.orderId = orderId;
        this.validate();
    }

    public BillDomainEntity(BigDecimal amount) {
        this.amount = amount;
        this.validate();
    }

    private void validate() {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("El monto debe ser mayor a 0");
        }
    }

}
