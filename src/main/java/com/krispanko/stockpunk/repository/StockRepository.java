package com.krispanko.stockpunk.repository;

import com.krispanko.stockpunk.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {}
