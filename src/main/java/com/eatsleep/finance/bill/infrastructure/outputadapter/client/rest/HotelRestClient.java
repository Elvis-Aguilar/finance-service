package com.eatsleep.finance.bill.infrastructure.outputadapter.client.rest;

import com.eatsleep.finance.bill.infrastructure.outputadapter.client.dto.ReservationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(name = "hotel", url = "${client.services.hotel}/api/hotel")
public interface HotelRestClient {

    @PutMapping("/v1/reservations/{id}")
    ReservationResponseDto payReservation(@PathVariable UUID id);

}
