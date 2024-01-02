package com.example.workshopproject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VehicleSearchCriteria {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;



}
