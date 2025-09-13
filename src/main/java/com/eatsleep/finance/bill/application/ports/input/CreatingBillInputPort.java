package com.eatsleep.finance.bill.application.ports.input;

import com.eatsleep.finance.bill.application.usecases.CreateBillCaseDto;
import com.eatsleep.finance.bill.domain.BillDomainEntity;

public interface CreatingBillInputPort {
    BillDomainEntity createBill(CreateBillCaseDto createBillCaseDto);
}
