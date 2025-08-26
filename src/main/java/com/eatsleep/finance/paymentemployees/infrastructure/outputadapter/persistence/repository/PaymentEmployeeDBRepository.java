package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.entity.PaymentEmployeesDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentEmployeeDBRepository extends JpaRepository<PaymentEmployeesDBEntity, UUID> {

    @Query("""
    SELECT p
    FROM payment_employee p
    WHERE p.startDate <= :endDate
      AND p.endDate >= :startDate
    """)
    List<PaymentEmployeesDBEntity> findAllByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
