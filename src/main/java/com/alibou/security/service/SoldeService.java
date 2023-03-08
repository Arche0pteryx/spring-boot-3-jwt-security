package com.alibou.security.service;


import com.alibou.security.model.Solde;
import com.alibou.security.repository.SoldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldeService {
    @Autowired
    private SoldeRepository soldeRepository      ;

    public List<Solde> getAllSoldes(Long idUser) {
        return soldeRepository.findByIdUser(idUser);
    }

    public List<Solde> findLastSoldeByIdUser(Long idUser) {
        System.out.println("findLastSoldeByIdUser");
        System.out.println(soldeRepository.findByIdUser(idUser).toString());
        return soldeRepository.findLastSoldeByIdUser(idUser);
    }


    public List<Solde> getAllSoldesWallet(Long idUser,Long idWallet) {
        System.out.println("getAllSoldesWallet");
        System.out.println(soldeRepository.findByIdUserAndIdWallet(idUser,idWallet).toString());
        return soldeRepository.findByIdUserAndIdWallet(idUser,idWallet);
    }

    public List<Solde> findLastSoldeByIdUserAndIdWallet(Long idUser,Long idWallet) {
        return soldeRepository.findByIdUserAndIdWallet(idUser,idWallet);
    }


}