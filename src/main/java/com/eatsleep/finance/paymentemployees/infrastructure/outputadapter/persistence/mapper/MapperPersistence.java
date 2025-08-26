package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.entity.PaymentEmployeesDBEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperPersistence {

    public PaymentEmployeesDomainEntity toDomain(PaymentEmployeesDBEntity paymentEmployeesDBEntity) {
        if (paymentEmployeesDBEntity == null) { return null; }

        return new PaymentEmployeesDomainEntity(paymentEmployeesDBEntity.getId(),
                paymentEmployeesDBEntity.getEmployeeId(),
                paymentEmployeesDBEntity.getAmount(),
                paymentEmployeesDBEntity.getStartDate(),
                paymentEmployeesDBEntity.getEndDate()
        );
    }

    public PaymentEmployeesDBEntity toDbEntity(PaymentEmployeesDomainEntity paymentEmployeesDomainEntity) {
        if (paymentEmployeesDomainEntity == null) { return null; }

        return new PaymentEmployeesDBEntity(paymentEmployeesDomainEntity.getEmployeeId(),
                paymentEmployeesDomainEntity.getAmount(),
                paymentEmployeesDomainEntity.getStartDate(),
                paymentEmployeesDomainEntity.getEndDate()
        );
    }
}
