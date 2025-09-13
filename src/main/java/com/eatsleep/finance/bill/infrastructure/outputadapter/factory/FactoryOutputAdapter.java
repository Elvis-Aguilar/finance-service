package com.eatsleep.finance.bill.infrastructure.outputadapter.factory;

import com.eatsleep.finance.bill.application.factory.CreatingBillFactory;
import com.eatsleep.finance.bill.application.usecases.CreateBillCaseDto;
import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.common.infrastructure.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

@Component
@RequiredArgsConstructor
public class FactoryOutputAdapter implements CreatingBillFactory {

    private static final Map<String, BiConsumer<BillDomainEntity, UUID>> referenceHandlers = Map.of(
            "reservation", BillDomainEntity::setReservationId,
            "order", BillDomainEntity::setOrderId
    );


    @Override
    public BillDomainEntity createBill(CreateBillCaseDto createBillCaseDto) {
        BillDomainEntity entity = new BillDomainEntity( createBillCaseDto.getAmount());

        referenceHandlers
                .getOrDefault(createBillCaseDto.getTypeReference().toLowerCase(),
                        (e, id) -> { throw new BadRequestException("Referencia no valida"); })
                .accept(entity, createBillCaseDto.getRefenceId());

        return entity;
    }
}
