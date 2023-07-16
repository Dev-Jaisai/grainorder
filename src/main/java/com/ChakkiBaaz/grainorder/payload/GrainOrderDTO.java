package com.ChakkiBaaz.grainorder.payload;

import lombok.Data;

@Data
public class GrainOrderDTO {
    private String grainType;
    private double quantity;
    private double pricePerKg;
    private double amount;
}