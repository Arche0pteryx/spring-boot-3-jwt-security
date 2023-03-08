package com.alibou.security.repository;

import com.alibou.security.model.Solde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoldeRepository extends JpaRepository<Solde, Long> {
    List<Solde> findByIdUser(Long idUser);

    List<Solde> findByIdUserAndIdWallet(Long idUser,Long idWallet);

    @Query(value = "SELECT * FROM soldes t where  t.idUser=?1  and t.dateff=(SELECT max(dateff) FROM soldes where  idUser=?1   and cryptoid=t.cryptoid)",nativeQuery = true)
    List<Solde> findLastSoldeByIdUser(Long idUser);
    @Query(value = "SELECT * FROM soldes t where  t.idUser=?1 and t.idWallet=?2 and t.dateff=(SELECT max(dateff) FROM soldes where  dUser=?1 and idWallet=?2 and idasset=t.idasset)",nativeQuery = true)
    List<Solde> findLastSoldeByIdUserAndIdWallet(Long idUser,Long idWallet);
}