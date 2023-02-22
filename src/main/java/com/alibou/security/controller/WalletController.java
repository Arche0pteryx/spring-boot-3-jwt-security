package com.alibou.security.controller;

import com.alibou.security.model.User;
import com.alibou.security.model.Wallet;
import com.alibou.security.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WalletController {
    @Autowired
    private WalletService walletService  ;

    @GetMapping("/wallet")
    public List<Wallet> getAllWallets(@AuthenticationPrincipal User user) {
        System.out.println("getAllWallets"+user.getId());
        return walletService.getAllWallets(user.getId());
    }

    @GetMapping("/wallet/{id}")
    public Wallet getWalletById(@PathVariable Long id,@AuthenticationPrincipal User user) {
        return walletService.getWalletById(id,user.getId());
    }

    @PostMapping("/wallet")
    public Wallet createWallet(@RequestBody Wallet wallet,@AuthenticationPrincipal User user) {
        wallet.setIdUser(user.getId());
        return walletService.createWallet(wallet);
    }

    @PutMapping("/wallet/{id}")
    public Wallet updateWallet(@PathVariable Long id, @RequestBody Wallet wallet,@AuthenticationPrincipal User user) {
        return walletService.updateWallet(id,wallet,user.getId());
    }

    @DeleteMapping("/wallet/{id}")
    public void deleteWallet(@PathVariable Long id,@AuthenticationPrincipal User user) {
        walletService.deleteWallet(id,user.getId());
    }
}
