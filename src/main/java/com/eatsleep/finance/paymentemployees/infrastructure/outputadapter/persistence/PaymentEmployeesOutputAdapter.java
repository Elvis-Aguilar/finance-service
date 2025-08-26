package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence;

import com.eatsleep.finance.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.finance.paymentemployees.application.ports.output.FindingPayEmployeesRangeDateOutputPort;
import com.eatsleep.finance.paymentemployees.application.ports.output.StoringPaymentWeeEmployeesOutputPort;
import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.entity.PaymentEmployeesDBEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.mapper.MapperPersistence;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.repository.PaymentEmployeeDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class PaymentEmployeesOutputAdapter implements FindingPayEmployeesRangeDateOutputPort, StoringPaymentWeeEmployeesOutputPort {

    private final PaymentEmployeeDBRepository paymentEmployeeDBRepository;
    private final MapperPersistence mapperPersistence;

    @Override
    @Transactional(readOnly = true)
    public List<PaymentEmployeesDomainEntity> findByRangeDate(LocalDate startDate, LocalDate endDate) {
        return this.paymentEmployeeDBRepository.findAllByDateRange(startDate, endDate)
                .stream()
                .map(mapperPersistence::toDomain)
                .toList();
    }

    @Override
    public boolean existRegistersRangeDate(LocalDate startDate, LocalDate endDate) {
        return !this.paymentEmployeeDBRepository.findAllByDateRange(startDate, endDate).isEmpty();
    }

    @Override
    @Transactional
    public List<PaymentEmployeesDomainEntity> savePaymentWeeEmployees(List<PaymentEmployeesDomainEntity> paymentEmployeesDomainEntityList) {
        List<PaymentEmployeesDBEntity> paymentEmployeesDBEntities = paymentEmployeesDomainEntityList.stream()
                .map(mapperPersistence::toDbEntity).toList();

        List<PaymentEmployeesDBEntity> paymentSaved =  paymentEmployeeDBRepository.saveAll(paymentEmployeesDBEntities);

        return paymentSaved.stream().map(mapperPersistence::toDomain).toList();
    }
}
