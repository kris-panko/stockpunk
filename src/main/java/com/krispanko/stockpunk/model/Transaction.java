package com.krispanko.stockpunk.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
    private String transactionType;
    private Integer quantity;
    private Double price;
    private LocalDateTime transactionDate;
}
