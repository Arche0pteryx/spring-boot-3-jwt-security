package com.alibou.security.service;
import com.alibou.security.model.User;
import com.alibou.security.repository.TransactionRepository;
import com.alibou.security.exception.ResourceNotFoundException;
import com.alibou.security.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository      ;

    public List<Transaction> getAllTransactions(Long idUser) {
        return transactionRepository.findByIdUser(idUser);
    }

    public Transaction getTransactionById(Long id,Long idUser) {
        Transaction transaction= transactionRepository.findById(id).orElse(  null);
        if (transaction.getIdUser() == idUser) {
            return transaction;
        }
        return null;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public  Transaction updateTransaction(Long  id, Transaction transactionDetails,Long idUser) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("transaction not exist with id :" + id));

        transaction.setDate(transactionDetails.getDate());
        transaction.setType(transactionDetails.getType());
        transaction.setCryptoIN(transactionDetails.getCryptoIN());
        transaction.setCryptoINamount(transactionDetails.getCryptoINamount());
        transaction.setCryptoOUT(transactionDetails.getCryptoOUT());
        transaction.setCryptoOUTamount(transactionDetails.getCryptoOUTamount());
        transaction.setIdUser(transactionDetails.getIdUser());
        transaction.setCryptoFEE(transactionDetails.getCryptoFEE());
        transaction.setCryptoFEEamount(transactionDetails.getCryptoFEEamount());
        return  transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}