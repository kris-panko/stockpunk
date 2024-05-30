package com.krispanko.stockpunk.repository;

import com.krispanko.stockpunk.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {}
