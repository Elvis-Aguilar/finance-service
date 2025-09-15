package com.eatsleep.finance.bill.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DetailsDomainEntity {

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal unitCost;
    private BigDecimal subtotal;
    private BigDecimal discountPercentage;
    private String dishName;


    public DetailsDomainEntity(Integer quantity, String dishName, BigDecimal discountPercentage, BigDecimal subtotal, BigDecimal unitPrice, BigDecimal unitCost) {
        this.quantity = quantity;
        this.dishName = dishName;
        this.discountPercentage = discountPercentage;
        this.subtotal = subtotal;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
    }
}
