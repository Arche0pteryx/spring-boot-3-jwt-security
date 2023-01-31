package com.alibou.security.controller;

import com.alibou.security.model.Asset;
import com.alibou.security.model.User;
import com.alibou.security.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AssetController {
    @Autowired
    private AssetService assetService  ;

    @GetMapping("/asset")
    public List<Asset> getAllAssets(@AuthenticationPrincipal User user) {
        return assetService.getAllAssets(user.getId());
    }

    @GetMapping("/asset/{id}")
    public Asset getAssetById(@PathVariable Long id,@AuthenticationPrincipal User user) {
        return assetService.getAssetById(id,user.getId());
    }

    @PostMapping("/asset")
    public Asset createAsset(@RequestBody Asset asset,@AuthenticationPrincipal User user) {
        asset.setIdUser(user.getId());
        return assetService.createAsset(asset);
    }

    @PutMapping("/asset/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset asset,@AuthenticationPrincipal User user) {
        return assetService.updateAsset(id,asset,user.getId());
    }

    @DeleteMapping("/asset/{id}")
    public void deleteAsset(@PathVariable Long id,@AuthenticationPrincipal User user) {
        assetService.deleteAsset(id);
    }
}
