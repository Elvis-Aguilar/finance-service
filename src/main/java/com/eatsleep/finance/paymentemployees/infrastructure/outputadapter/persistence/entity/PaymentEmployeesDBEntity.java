package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "payment_employee")
@Table(name = "payment_employee", schema = "finance")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class PaymentEmployeesDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private UUID employeeId;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @NonNull
    @Column(nullable = false)
    private LocalDate startDate;

    @NonNull
    @Column(nullable = false)
    private LocalDate endDate;

    @CreationTimestamp
    private Instant paymentDate;

    @UpdateTimestamp
    private Instant updatedAt;

}
