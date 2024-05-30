package com.krispanko.stockpunk.repository;

import com.krispanko.stockpunk.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
