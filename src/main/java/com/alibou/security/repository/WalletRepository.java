package com.alibou.security.repository;

import com.alibou.security.model.Transaction;
import com.alibou.security.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    List<Wallet> findByIdUser(Long idUser);
}
