package com.krispanko.stockpunk.service;

import com.krispanko.stockpunk.model.Transaction;
import com.krispanko.stockpunk.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction != null) {
            transaction.setTransactionType(transactionDetails.getTransactionType());
            transaction.setQuantity(transactionDetails.getQuantity());
            transaction.setPrice(transactionDetails.getPrice());
            transaction.setTransactionDate(transactionDetails.getTransactionDate());
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
