package com.eatsleep.finance.paymentemployees.application.usecase;

import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class PaymentWeekAllEmployeesDto {
    LocalDate startDate;
    LocalDate endDate;
}
