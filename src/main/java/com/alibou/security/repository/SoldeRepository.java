package com.alibou.security.repository;

import com.alibou.security.model.Solde;
import com.alibou.security.model.SoldeSUM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
@Repository("soldeRepository")
public interface SoldeRepository extends JpaRepository<Solde, Long> {
    List<Solde> findByIdUser(Long idUser);

    List<Solde> findByIdUserAndIdWallet(Long idUser,Long idWallet);

    @Query(value = "SELECT  crypto,cryptoid ,SUM(soldeachat) soldeachat,SUM(valeurachat) valeurachat,SUM(soldevente) soldevente,SUM(valeurvente) valeurvente,SUM(avgBuyPrice)  avgBuyPrice ,SUM(avgSellPrice)  avgSellPrice, SUM(solde) solde, to_date('10/01/2022','DD/MM/YYYY') dateff,to_date('10/01/2022','DD/MM/YYYY') datfin FROM soldes t where  t.idUser=?1  and t.dateff=(SELECT max(dateff) FROM soldes where  idUser=?1  and cryptoid=t.cryptoid and idwallet=t.idwallet) group by crypto,cryptoid",nativeQuery = true)
    List<Object[]> findLastSoldeByIdUser(Long idUser);

    @Query(value = "SELECT * FROM soldes t where  t.idUser=?1 and t.idWallet=?2 and t.dateff=(SELECT max(dateff) FROM soldes where  dUser=?1 and idWallet=?2 and idasset=t.idasset)",nativeQuery = true)
    List<Solde> findLastSoldeByIdUserAndIdWallet(Long idUser,Long idWallet);
}