package com.krispanko.stockpunk.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String name;
    private Double currentPrice;
    @Lob
    private String historicalData;
}
