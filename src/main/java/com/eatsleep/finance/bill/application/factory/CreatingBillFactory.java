package com.eatsleep.finance.bill.application.factory;

import com.eatsleep.finance.bill.application.usecases.CreateBillCaseDto;
import com.eatsleep.finance.bill.domain.BillDomainEntity;

public interface CreatingBillFactory {
    BillDomainEntity createBill(CreateBillCaseDto createBillCaseDto);
}
