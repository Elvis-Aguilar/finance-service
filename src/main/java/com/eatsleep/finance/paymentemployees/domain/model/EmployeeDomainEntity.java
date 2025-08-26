package com.eatsleep.finance.paymentemployees.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class EmployeeDomainEntity {
    private UUID id;
    private BigDecimal salary;

    public EmployeeDomainEntity(UUID id, BigDecimal salary) {
        this.id = id;
        this.salary = salary;
    }

    public PaymentEmployeesDomainEntity toDomain(LocalDate StartDate, LocalDate EndDate) {
        return new PaymentEmployeesDomainEntity(id, salary, StartDate, EndDate);
    }
}
