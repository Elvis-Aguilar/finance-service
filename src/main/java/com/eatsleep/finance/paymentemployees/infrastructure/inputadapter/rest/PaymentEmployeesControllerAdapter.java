package com.eatsleep.finance.paymentemployees.infrastructure.inputadapter.rest;

import com.eatsleep.finance.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.finance.paymentemployees.application.ports.input.PayWeekAllEmployeesInputPort;
import com.eatsleep.finance.paymentemployees.application.usecase.PaymentWeekAllEmployeesDto;
import com.eatsleep.finance.paymentemployees.infrastructure.inputadapter.dto.PayRangeDateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/payments/employees")
@WebAdapter
@RequiredArgsConstructor
public class PaymentEmployeesControllerAdapter {

    private final PayWeekAllEmployeesInputPort payWeekAllEmployeesInputPort;

    @PostMapping()
    @Transactional
    public ResponseEntity<Void> paymentAllEmployees(@RequestBody @Valid PayRangeDateRequestDto payRangeDateRequestDto) {
        PaymentWeekAllEmployeesDto paymentWeekAllEmployeesDto = payRangeDateRequestDto.toDomain();

        payWeekAllEmployeesInputPort.paymentWeekAllEmployees(paymentWeekAllEmployeesDto);

        return ResponseEntity.ok().build();
    }

}
