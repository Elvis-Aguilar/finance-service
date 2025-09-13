package com.eatsleep.finance.bill.application.usecases;

import com.eatsleep.finance.bill.application.factory.CreatingBillFactory;
import com.eatsleep.finance.bill.application.ports.input.CreatingBillInputPort;
import com.eatsleep.finance.bill.application.ports.output.FindingBillByReservationIdOutputPort;
import com.eatsleep.finance.bill.application.ports.output.PayingReservationOutputPort;
import com.eatsleep.finance.bill.application.ports.output.StoringBillOutputPort;
import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.common.application.annotations.UseCase;
import com.eatsleep.finance.common.application.exception.EntityAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@UseCase
@Validated
@RequiredArgsConstructor
public class CreateBillUseCase implements CreatingBillInputPort {

    private final StoringBillOutputPort outputPort;
    private final CreatingBillFactory factory;
    private final PayingReservationOutputPort payingReservationOutputPort;
    private final FindingBillByReservationIdOutputPort findingBillByReservationIdOutputPort;

    @Override
    @Transactional
    public BillDomainEntity createBill(CreateBillCaseDto createBillCaseDto) {

        boolean isReservation = "reservation".equalsIgnoreCase(createBillCaseDto.getTypeReference());

        if (isReservation && findingBillByReservationIdOutputPort.findBillByReservationId(createBillCaseDto.getRefenceId()).isPresent()) {
            // validar que no exista el bill
            throw new EntityAlreadyExistsException("Factura ya cobrada, no se puede realizar el cobro dos veces");
        }

        // crear bill
        BillDomainEntity entity = factory.createBill(createBillCaseDto);
        BillDomainEntity entitySaved = outputPort.saveBill(entity);

        // cambiar estado reservacion si aplica
        if (isReservation) {
            payingReservationOutputPort.payingReservation(entitySaved.getReservationId());
        }

        return entitySaved;
    }
}
