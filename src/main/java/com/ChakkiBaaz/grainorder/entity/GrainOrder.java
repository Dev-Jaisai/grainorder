package com.ChakkiBaaz.grainorder.entity;
import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "grain_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrainOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grainType;

    private double quantity;

    private double pricePerKg;

    private double amount;
}
