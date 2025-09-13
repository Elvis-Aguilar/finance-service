package com.eatsleep.finance.bill.infrastructure.outputadapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "bill")
@Table(name = "bill", schema = "finance")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class BillDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private BigDecimal amount;

    @Builder.Default
    @Column(nullable = false)
    private String paymentMethod = "TARJETA";

    @Column(nullable = true)
    private UUID reservationId;

    @Column(nullable = true)
    private UUID orderId;

    @CreationTimestamp
    private Instant paymentDate;

    @UpdateTimestamp
    private Instant updatedAt;
}
