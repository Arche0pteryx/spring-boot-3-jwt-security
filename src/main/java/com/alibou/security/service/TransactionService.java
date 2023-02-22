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

    public List<Transaction> getAllTransactionsWallet(Long idUser,Long idWallet) {
        return transactionRepository.findByIdUserAndIdWallet(idUser,idWallet);
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

        transaction.setIdWallet(transactionDetails.getIdWallet());
        transaction.setDate(transactionDetails.getDate());
        transaction.setType(transactionDetails.getType());
        transaction.setCryptoIN(transactionDetails.getCryptoIN());
        transaction.setCryptoINid(transactionDetails.getCryptoINid());
        transaction.setCryptoINamount(transactionDetails.getCryptoINamount());
        transaction.setCryptoINprice(transactionDetails.getCryptoINprice());
        transaction.setCryptoOUT(transactionDetails.getCryptoOUT());
        transaction.setCryptoOUTid(transactionDetails.getCryptoOUTid());
        transaction.setCryptoOUTamount(transactionDetails.getCryptoOUTamount());
        transaction.setCryptoOUTprice(transactionDetails.getCryptoOUTprice());
        transaction.setIdUser(transactionDetails.getIdUser());
        transaction.setCryptoFEE(transactionDetails.getCryptoFEE());
        transaction.setCryptoFEEid(transactionDetails.getCryptoFEEid());
        transaction.setCryptoFEEamount(transactionDetails.getCryptoFEEamount());
        return  transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}