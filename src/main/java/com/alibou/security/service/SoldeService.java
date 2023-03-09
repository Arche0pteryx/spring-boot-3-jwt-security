package com.alibou.security.service;


import com.alibou.security.model.Solde;
import com.alibou.security.model.SoldeSUM;
import com.alibou.security.repository.SoldeRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

@Service
public class SoldeService {
    @Autowired
    private SoldeRepository soldeRepository      ;

    public List<Solde> getAllSoldes(Long idUser) {
        return soldeRepository.findByIdUser(idUser);
    }
    public List<Solde> getAllSoldesWallet(Long idUser,Long idWallet) {
        return soldeRepository.findByIdUserAndIdWallet(idUser,idWallet);
    }
    public List<Solde> findLastSoldeByIdUser(Long idUser) {
        return  objectToSoldeTransformer(soldeRepository.findLastSoldeByIdUser( idUser));
    }
    public List<Solde> findLastSoldeByIdUserAndIdWallet(Long idUser,Long idWallet) {
        return soldeRepository.findByIdUserAndIdWallet(idUser,idWallet);
    }


    private List<Solde> objectToSoldeTransformer (List<Object[]> objects){
        List<Solde> soldes = new ArrayList<>();
        objects.forEach(soldeCumul -> {
            Solde solde = new Solde();
            System.out.println(soldeCumul[0]);
            solde.setCrypto((String)soldeCumul[0]);
            solde.setCryptoid((String)soldeCumul[1]);
            if (soldeCumul[2] != null) {
                solde.setSoldeAchat(((BigDecimal)soldeCumul[2]).doubleValue());
            }
            if (soldeCumul[3] != null) {
                solde.setValeurAchat(((BigDecimal)soldeCumul[3]).doubleValue());
            }
            if (soldeCumul[4] != null) {
                solde.setSoldeVente(((BigDecimal)soldeCumul[4]).doubleValue());
            }
            if (soldeCumul[5] != null) {
                solde.setValeurVente(((BigDecimal)soldeCumul[5]).doubleValue());
            }
            if (soldeCumul[6] != null) {
                solde.setAvgBuyPrice(((BigDecimal) soldeCumul[6]).doubleValue());
            }
            if (soldeCumul[7] != null) {
                solde.setAvgSellPrice (((BigDecimal)soldeCumul[7]).doubleValue());
            }
            if (soldeCumul[8] != null) {
                solde.setSolde(((BigDecimal)soldeCumul[8]).doubleValue());
            }
            if (soldeCumul[9] != null) {
                solde.setDateff((Date)soldeCumul[9]);
            }
            if (soldeCumul[10] != null) {
                solde.setDatfin((Date)soldeCumul[10]);
            }
            soldes.add(solde);
        });
        return soldes;
    }
}