package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.mappers;

import com.eatsleep.finance.paymentemployees.domain.model.EmployeeDomainEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.dto.EmployeesResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDomainEntity toDomain(EmployeesResponseDto employeesResponseDto) {
        return new EmployeeDomainEntity(employeesResponseDto.id(), employeesResponseDto.salary());
    }
}
