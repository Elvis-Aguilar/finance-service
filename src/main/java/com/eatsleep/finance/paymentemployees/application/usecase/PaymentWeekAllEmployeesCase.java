package com.eatsleep.finance.paymentemployees.application.usecase;


import com.eatsleep.finance.common.application.annotations.UseCase;
import com.eatsleep.finance.common.application.exception.EntityAlreadyExistsException;
import com.eatsleep.finance.common.application.exception.InvalidPropertyUseCase;
import com.eatsleep.finance.paymentemployees.application.ports.input.PayWeekAllEmployeesInputPort;
import com.eatsleep.finance.paymentemployees.application.ports.output.FindingAllEmployeesOutputPort;
import com.eatsleep.finance.paymentemployees.application.ports.output.FindingPayEmployeesRangeDateOutputPort;
import com.eatsleep.finance.paymentemployees.application.ports.output.StoringPaymentWeeEmployeesOutputPort;
import com.eatsleep.finance.paymentemployees.domain.model.EmployeeDomainEntity;
import com.eatsleep.finance.paymentemployees.domain.model.PaymentEmployeesDomainEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.temporal.ChronoUnit;
import java.util.List;

@UseCase
@Validated
@RequiredArgsConstructor
public class PaymentWeekAllEmployeesCase implements PayWeekAllEmployeesInputPort {

    private final FindingPayEmployeesRangeDateOutputPort findingPayEmployeesRangeDateOutputPort;
    private final FindingAllEmployeesOutputPort findingAllEmployeesOutputPort;
    private final StoringPaymentWeeEmployeesOutputPort storingPaymentWeeEmployeesOutputPort;

    @Override
    @Transactional
    public List<PaymentEmployeesDomainEntity> paymentWeekAllEmployees(PaymentWeekAllEmployeesDto  paymentWeekAllEmployeesDto) {

        // validar que rango de fechas no exista en los registros
        if(findingPayEmployeesRangeDateOutputPort.existRegistersRangeDate(paymentWeekAllEmployeesDto.getStartDate(), paymentWeekAllEmployeesDto.getEndDate())){
            throw new EntityAlreadyExistsException("En este periodo de fehcas y se encuentras pagos realizados");
        }

        // validar que sea de rango 7 dias
        long days = ChronoUnit.DAYS.between(paymentWeekAllEmployeesDto.getStartDate(), paymentWeekAllEmployeesDto.getEndDate()) + 1;
         if (days != 7){
            throw new InvalidPropertyUseCase("El rango de fechas no es de una semana (7 dias).");
         }

        // obtener a todos los empleados con sus salarios otro microservicio
        List<EmployeeDomainEntity> employeeDomainEntity = findingAllEmployeesOutputPort.findAllEmployees();

         if (employeeDomainEntity.isEmpty()){
             throw new InvalidPropertyUseCase("No hay empleados encontrados para el pago de semana");
         }

        //realiza pago
        List<PaymentEmployeesDomainEntity> employeesDomainEntities = employeeDomainEntity
                        .stream()
                        .map(emp -> emp.toDomain(paymentWeekAllEmployeesDto.getStartDate(), paymentWeekAllEmployeesDto.getEndDate()))
                        .toList();

        return this.storingPaymentWeeEmployeesOutputPort.savePaymentWeeEmployees(employeesDomainEntities);
    }


}
