package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client;


import com.eatsleep.finance.common.infrastructure.exceptions.ExternalServiceException;
import com.eatsleep.finance.paymentemployees.application.ports.output.FindingAllEmployeesOutputPort;
import com.eatsleep.finance.paymentemployees.domain.model.EmployeeDomainEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.mappers.EmployeeMapper;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.rest.AuthIdentityRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesOutputAdapter implements FindingAllEmployeesOutputPort {

    private final AuthIdentityRestClient authIdentityRestClient;
    private final EmployeeMapper employeeMapper;


    @Override
    public List<EmployeeDomainEntity> findAllEmployees() {
        try {
            return authIdentityRestClient.findAllEmployees().stream()
                    .map(employeeMapper::toDomain)
                    .toList();

        } catch (FeignException e) {
            throw new ExternalServiceException("No se pudieron obtener empleados en el servico.");
        }
    }
}
