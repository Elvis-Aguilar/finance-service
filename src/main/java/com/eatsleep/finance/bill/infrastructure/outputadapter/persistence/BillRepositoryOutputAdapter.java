package com.eatsleep.finance.bill.infrastructure.outputadapter.persistence;

import com.eatsleep.finance.bill.application.ports.output.FindingBillByOrderIdOutputPort;
import com.eatsleep.finance.bill.application.ports.output.FindingBillByReservationIdOutputPort;
import com.eatsleep.finance.bill.application.ports.output.StoringBillOutputPort;
import com.eatsleep.finance.bill.domain.BillDomainEntity;
import com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.entity.BillDBEntity;
import com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.mapper.BillPersistenceMapper;
import com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.repository.BillDBRepository;
import com.eatsleep.finance.common.infrastructure.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class BillRepositoryOutputAdapter implements StoringBillOutputPort, FindingBillByReservationIdOutputPort,
        FindingBillByOrderIdOutputPort {

    private final BillDBRepository billDBRepository;
    private final BillPersistenceMapper mapper;

    @Override
    public BillDomainEntity saveBill(BillDomainEntity billDomainEntity) {
        BillDBEntity dbEntity = mapper.toDBEntity(billDomainEntity);
        BillDBEntity dbSavedEntity = billDBRepository.save(dbEntity);
        return mapper.toDomainEntity(dbSavedEntity);
    }

    @Override
    public Optional<BillDomainEntity> findBillByReservationId(UUID reservationId) {
        return billDBRepository.findByReservationId(reservationId)
                .map(mapper::toDomainEntity);
    }

    @Override
    public Optional<BillDomainEntity> findBillByOrderId(UUID orderId) {
        return billDBRepository.findByOrderId(orderId)
                .map(mapper::toDomainEntity);
    }
}
