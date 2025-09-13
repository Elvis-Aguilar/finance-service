package com.eatsleep.finance.bill.infrastructure.outputadapter.client.mapper;

import com.eatsleep.finance.bill.domain.ReservationDomainEntity;
import com.eatsleep.finance.bill.infrastructure.outputadapter.client.dto.ReservationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationRestMapper {

    public ReservationDomainEntity toDomainEntity(ReservationResponseDto dto) {
        return new  ReservationDomainEntity(dto.id(),
                dto.customerId(),
                dto.startDate(),
                dto.endDate(),
                dto.state(),
                dto.pricePerDay(),
                dto.totalPrice(),
                dto.maintenanceCostPerDay(),
                dto.totalCost(),
                dto.discountPercentage(),
                dto.roomId(),
                null);

    }
}
