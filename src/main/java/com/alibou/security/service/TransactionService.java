package com.alibou.security.service;
import com.alibou.security.repository.TransactionRepository;
import com.alibou.security.exception.ResourceNotFoundException;
import com.alibou.security.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository      ;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(  null);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public  Transaction updateTransaction(Long  id, Transaction transactionDetails) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("transaction not exist with id :" + id));

        transaction.setDate(transactionDetails.getDate());
        transaction.setCryptoCurrencyAfter(transactionDetails.getCryptoCurrencyAfter());
        transaction.setCryptoCurrencyBefore(transactionDetails.getCryptoCurrencyBefore());
        transaction.setCryptoCurrencyAmountAfter(transactionDetails.getCryptoCurrencyAmountAfter());
        transaction.setCryptoCurrencyAmountBefore( transactionDetails.getCryptoCurrencyAmountBefore());

        return  transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}