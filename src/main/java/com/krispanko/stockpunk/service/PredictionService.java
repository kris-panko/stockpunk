package com.krispanko.stockpunk.service;

import com.krispanko.stockpunk.model.Prediction;
import com.krispanko.stockpunk.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    @Autowired
    private PredictionRepository predictionRepository;

    public List<Prediction> getAllPredictions() {
        return predictionRepository.findAll();
    }

    public Prediction createPrediction(Prediction prediction) {
        return predictionRepository.save(prediction);
    }

    public Prediction getPredictionById(Long id) {
        return predictionRepository.findById(id).orElse(null);
    }

    public Prediction updatePrediction(Long id, Prediction predictionDetails) {
        Prediction prediction = predictionRepository.findById(id).orElse(null);
        if (prediction != null) {
            prediction.setPredictedPrice(predictionDetails.getPredictedPrice());
            prediction.setPredictionDate(predictionDetails.getPredictionDate());
            return predictionRepository.save(prediction);
        }
        return null;
    }

    public void deletePrediction(Long id) {
        predictionRepository.deleteById(id);
    }
}
