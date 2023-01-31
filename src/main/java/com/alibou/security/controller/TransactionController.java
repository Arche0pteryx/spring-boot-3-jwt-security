package com.alibou.security.controller;
import java.util.List;

import com.alibou.security.model.User;
import com.alibou.security.service.TransactionService;
import com.alibou.security.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService  ;

    @GetMapping("/transaction")
    public List<Transaction> getAllTransactions(@AuthenticationPrincipal User user) {
        return transactionService.getAllTransactions(user.getId());
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable Long id,@AuthenticationPrincipal User user) {
        return transactionService.getTransactionById(id,user.getId());
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction,@AuthenticationPrincipal User user) {
        transaction.setIdUser(user.getId());
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/transaction/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction,@AuthenticationPrincipal User user) {
        return transactionService.updateTransaction(id,transaction,user.getId());
    }

    @DeleteMapping("/transaction/{id}")
    public void deleteTransaction(@PathVariable Long id,@AuthenticationPrincipal User user) {
        transactionService.deleteTransaction(id);
    }
}