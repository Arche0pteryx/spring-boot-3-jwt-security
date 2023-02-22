package com.alibou.security.service;

import com.alibou.security.exception.ResourceNotFoundException;
import com.alibou.security.model.Transaction;
import com.alibou.security.model.Wallet;
import com.alibou.security.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository      ;

    public List<Wallet> getAllWallets(Long idUser) {
        return walletRepository.findByIdUser(idUser);
    }

    public Wallet getWalletById(Long id,Long idUser) {
        Wallet wallet= walletRepository.findById(id).orElse(  null);
        if (wallet.getIdUser() == idUser) {
            return wallet;
        }
        return null;
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public  Wallet updateWallet(Long  id, Wallet walletDetails,Long idUser) {

        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("wallet not exist with id :" + id));

        wallet.setName(walletDetails.getName());
        wallet.setExchangeId(walletDetails.getExchangeId());
        wallet.setPublicKey(walletDetails.getPublicKey());
        wallet.setBlockchain( walletDetails.getBlockchain());
        wallet.setDate(walletDetails.getDate());

        return  walletRepository.save(wallet);
    }

    public void deleteWallet(Long id,Long idUser) {
        walletRepository.deleteById(id);
    }
}