package com.eatsleep.finance.bill.application.ports.output;

import com.eatsleep.finance.bill.domain.BillDomainEntity;

public interface StoringBillOutputPort {
    BillDomainEntity saveBill(BillDomainEntity billDomainEntity);
}
