package com.eatsleep.finance.paymentemployees.application.ports.output;

import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;

import java.util.List;

public interface StoringPaymentWeeEmployeesOutputPort {
    List<PaymentEmployeesDomainEntity> savePaymentWeeEmployees(List<PaymentEmployeesDomainEntity> paymentEmployeesDomainEntityList);
}
