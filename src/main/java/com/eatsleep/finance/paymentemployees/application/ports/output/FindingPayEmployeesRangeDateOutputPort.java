package com.eatsleep.finance.paymentemployees.application.ports.output;

import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;

import java.time.LocalDate;
import java.util.List;

public interface FindingPayEmployeesRangeDateOutputPort {
    List<PaymentEmployeesDomainEntity> findByRangeDate(LocalDate startDate, LocalDate endDate);

    boolean existRegistersRangeDate(LocalDate startDate, LocalDate endDate);
}
