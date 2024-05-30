package com.krispanko.stockpunk.controller;

import com.krispanko.stockpunk.model.Prediction;
import com.krispanko.stockpunk.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping
    public List<Prediction> getAllPredictions() {
        return predictionService.getAllPredictions();
    }

    @PostMapping
    public Prediction createPrediction(@RequestBody Prediction prediction) {
        return predictionService.createPrediction(prediction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prediction> getPredictionById(@PathVariable Long id) {
        Prediction prediction = predictionService.getPredictionById(id);
        if (prediction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prediction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prediction> updatePrediction(@PathVariable Long id, @RequestBody Prediction predictionDetails) {
        Prediction updatedPrediction = predictionService.updatePrediction(id, predictionDetails);
        if (updatedPrediction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrediction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrediction(@PathVariable Long id) {
        predictionService.deletePrediction(id);
        return ResponseEntity.noContent().build();
    }
}
