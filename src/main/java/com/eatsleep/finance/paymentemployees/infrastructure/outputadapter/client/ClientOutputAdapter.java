package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client;


import com.eatsleep.finance.bill.application.ports.output.PayingReservationOutputPort;
import com.eatsleep.finance.bill.domain.ReservationDomainEntity;
import com.eatsleep.finance.bill.infrastructure.outputadapter.client.mapper.ReservationRestMapper;
import com.eatsleep.finance.bill.infrastructure.outputadapter.client.rest.HotelRestClient;
import com.eatsleep.finance.common.infrastructure.exceptions.ExternalServiceException;
import com.eatsleep.finance.paymentemployees.application.ports.output.FindingAllEmployeesOutputPort;
import com.eatsleep.finance.paymentemployees.domain.model.EmployeeDomainEntity;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.mappers.EmployeeMapper;
import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.rest.AuthIdentityRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientOutputAdapter implements FindingAllEmployeesOutputPort, PayingReservationOutputPort {

    private final AuthIdentityRestClient authIdentityRestClient;
    private final EmployeeMapper employeeMapper;
    private final HotelRestClient hotelRestClient;
    private final ReservationRestMapper reservationRestMapper;



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

    @Override
    public ReservationDomainEntity payingReservation(UUID reservationId) {
        try {
            return reservationRestMapper.toDomainEntity(hotelRestClient.payReservation(reservationId));

        } catch (FeignException e) {
            throw new ExternalServiceException("No se realizar el pago de la reservacion.");
        }
    }
}
