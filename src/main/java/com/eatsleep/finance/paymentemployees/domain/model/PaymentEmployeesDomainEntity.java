package com.eatsleep.finance.paymentemployees.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class PaymentEmployeesDomainEntity {

    private UUID id;
    private UUID employeeId;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public PaymentEmployeesDomainEntity(UUID id, UUID employeeId, BigDecimal amount, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PaymentEmployeesDomainEntity(UUID employeeId, BigDecimal amount, LocalDate startDate, LocalDate endDate) {
        this.employeeId = employeeId;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
