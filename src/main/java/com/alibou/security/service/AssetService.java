package com.alibou.security.service;

import com.alibou.security.exception.ResourceNotFoundException;
import com.alibou.security.model.Asset;
import com.alibou.security.model.Transaction;
import com.alibou.security.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets(Long idUser) {
        return assetRepository.findByIdUser(idUser);
    }

    public Asset getAssetById(Long id,Long idUser) {
        Asset asset= assetRepository.findById(id).orElse(  null);
        if (asset.getIdUser() == idUser) {
            return asset;
        }
        return null;
    }

    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public  Asset updateAsset(Long  id, Asset assetDetails,Long idUser) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("asset not exist with id :" + id));

        asset.setDate(assetDetails.getDate());
        asset.setCrypto(assetDetails.getCrypto());
        asset.setCryptoAmount(assetDetails.getCryptoAmount());
        asset.setIdUser(assetDetails.getIdUser());
        return  assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
