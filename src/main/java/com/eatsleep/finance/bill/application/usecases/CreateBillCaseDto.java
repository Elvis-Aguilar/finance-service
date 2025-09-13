package com.eatsleep.finance.bill.application.usecases;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@AllArgsConstructor
public class CreateBillCaseDto {

    UUID refenceId;
    String typeReference;
    BigDecimal amount;
}
