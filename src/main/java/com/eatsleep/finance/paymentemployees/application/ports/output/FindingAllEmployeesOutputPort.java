package com.eatsleep.finance.paymentemployees.application.ports.output;

import com.eatsleep.finance.paymentemployees.domain.model.EmployeeDomainEntity;

import java.util.List;

public interface FindingAllEmployeesOutputPort {
    List<EmployeeDomainEntity> findAllEmployees();
}
