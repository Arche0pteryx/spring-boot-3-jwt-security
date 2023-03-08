package com.alibou.security.controller;

import com.alibou.security.model.Solde;
import com.alibou.security.model.User;
import com.alibou.security.service.SoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SoldeController {
    @Autowired
    private SoldeService soldeService  ;

    @GetMapping("/solde")
    public List<Solde> findLastSoldeByIdUser(@AuthenticationPrincipal User user) {
        return soldeService.findLastSoldeByIdUser(user.getId());
    }

    @GetMapping("wallet/solde/{id}")
    public List<Solde> findLastSoldeByIdUserAndIdWallet(@PathVariable Long id,@AuthenticationPrincipal User user) {
        return soldeService.findLastSoldeByIdUserAndIdWallet(user.getId(),id);
    }
}
