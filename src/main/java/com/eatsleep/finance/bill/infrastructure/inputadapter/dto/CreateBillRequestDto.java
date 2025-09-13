package com.eatsleep.finance.bill.infrastructure.inputadapter.dto;

import com.eatsleep.finance.bill.application.usecases.CreateBillCaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class CreateBillRequestDto {

    @NotNull
    UUID refenceId;
    @NotBlank
    String typeReference;
    @Positive
    BigDecimal amount;

    public CreateBillCaseDto toCreateBillCaseDto() {
        return new CreateBillCaseDto(refenceId, typeReference, amount);
    }
}
