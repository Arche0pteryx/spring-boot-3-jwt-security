package com.alibou.security.repository;

import com.alibou.security.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByIdUser(Long idUser);

    List<Asset> findByIdUserAndIdWallet(Long idUser,Long idWallet);

    }