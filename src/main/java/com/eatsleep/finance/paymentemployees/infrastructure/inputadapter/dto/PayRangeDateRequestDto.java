package com.eatsleep.finance.paymentemployees.infrastructure.inputadapter.dto;

import com.eatsleep.finance.paymentemployees.application.usecase.PaymentWeekAllEmployeesDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PayRangeDateRequestDto {

    @NotBlank
    String startDate;
    @NotBlank
    String endDate;

    public PaymentWeekAllEmployeesDto toDomain() {
        return new PaymentWeekAllEmployeesDto(
                LocalDate.parse(startDate),  // "yyyy-mm-dd"
                LocalDate.parse(endDate)
        );
    }
}
