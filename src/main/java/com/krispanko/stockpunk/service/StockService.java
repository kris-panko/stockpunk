package com.krispanko.stockpunk.service;

import com.krispanko.stockpunk.model.Stock;
import com.krispanko.stockpunk.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stock.setSymbol(stockDetails.getSymbol());
            stock.setName(stockDetails.getName());
            stock.setCurrentPrice(stockDetails.getCurrentPrice());
            stock.setHistoricalData(stockDetails.getHistoricalData());
            return stockRepository.save(stock);
        }
        return null;
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
