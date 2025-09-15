package com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.entity.BillDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BillDBRepository extends JpaRepository<BillDBEntity, UUID> {

    Optional<BillDBEntity> findByReservationId(UUID reservationId);

    Optional<BillDBEntity> findByOrderId(UUID orderId);

}
