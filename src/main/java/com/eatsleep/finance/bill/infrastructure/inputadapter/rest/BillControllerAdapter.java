package com.eatsleep.finance.bill.infrastructure.inputadapter.rest;


import com.eatsleep.finance.bill.application.ports.input.CreatingBillInputPort;
import com.eatsleep.finance.bill.application.usecases.CreateBillCaseDto;
import com.eatsleep.finance.bill.infrastructure.inputadapter.dto.CreateBillRequestDto;
import com.eatsleep.finance.common.infrastructure.annotation.WebAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/bills")
@WebAdapter
@RequiredArgsConstructor
public class BillControllerAdapter {

    private final CreatingBillInputPort creatingBillInputPort;

    @PostMapping("")
    public ResponseEntity<Void> createBill(@RequestBody @Valid CreateBillRequestDto requestDto) {
        CreateBillCaseDto createBillCaseDto = requestDto.toCreateBillCaseDto();
        creatingBillInputPort.createBill(createBillCaseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
