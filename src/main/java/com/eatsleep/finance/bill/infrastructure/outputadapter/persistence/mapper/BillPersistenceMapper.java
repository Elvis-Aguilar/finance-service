package com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.entity.BillDBEntity;
import org.springframework.stereotype.Component;

@Component
public class BillPersistenceMapper {

    public BillDBEntity toDBEntity(BillDomainEntity entity) {

        if (entity == null) {return null;}

        return BillDBEntity.builder()
                .amount(entity.getAmount())
                .orderId(entity.getOrderId())
                .paymentDate(entity.getPaymentDate())
                .reservationId(entity.getReservationId())
                .build();

    }

    public BillDomainEntity toDomainEntity(BillDBEntity entity) {
        if (entity == null) {return null;}

        return new BillDomainEntity(entity.getId(),
                entity.getAmount(),
                entity.getReservationId(),
                entity.getOrderId(),
                entity.getPaymentDate());
    }
}
