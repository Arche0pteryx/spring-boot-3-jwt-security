package com.alibou.security.repository;
import com.alibou.security.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {
    List<Transaction> findByIdUser(Long idUser);

    List<Transaction> findByIdUserAndIdWallet(Long idUser,Long idWallet);
}

