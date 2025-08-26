package com.eatsleep.finance.paymentemployees.application.ports.input;

import com.eatsleep.finance.paymentemployees.application.usecase.PaymentWeekAllEmployeesDto;
import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;

import java.util.List;

public interface PayWeekAllEmployeesInputPort {

    List<PaymentEmployeesDomainEntity> paymentWeekAllEmployees(PaymentWeekAllEmployeesDto paymentWeekAllEmployeesDto);
}
