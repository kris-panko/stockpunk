package com.krispanko.stockpunk.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
    private Double predictedPrice;
    private LocalDate predictionDate;
}
