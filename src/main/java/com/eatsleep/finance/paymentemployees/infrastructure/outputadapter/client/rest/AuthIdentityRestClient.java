package com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.rest;

import com.eatsleep.finance.paymentemployees.infrastructure.outputadapter.client.dto.EmployeesResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "auth-identity", url = "${client.services.auth-identity}/api/auth-identity")
public interface AuthIdentityRestClient {

    @GetMapping("/v1/employees")
    List<EmployeesResponseDto> findAllEmployees();
}
