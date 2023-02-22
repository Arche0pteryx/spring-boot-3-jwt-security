package com.alibou.security.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="assets")
public class Asset {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iduser")
    private long idUser;

    @Column(name = "idwallet")
    private long idWallet;
    @Column(name = "crypto")
    private String crypto;

    @Column(name = "cryptoid")
    private String cryptoId;
    @Column(name = "cryptoamount")
    private Double cryptoAmount;

    @Column(name = "avgbuyprice")
    private Double avgBuyPrice;
    @Column(name = "date")
    private Date date;

    // Constructor
    public Asset() {
    }
    public Asset(long idUser, String crypto, String cryptoId, Double cryptoAmount,Double avgBuyPrice, Date date) {
        super();
        this.idUser = idUser;
        this.crypto = crypto;
        this.cryptoId = cryptoId;
        this.cryptoAmount = cryptoAmount;
        this.avgBuyPrice= avgBuyPrice;
        this.date = date;
    }
    //  Getters and Setters
    public String getCrypto() {
        return crypto;
    }
    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }
    public Double getCryptoAmount() {
        return cryptoAmount;
    }
    public void setCryptoAmount(Double cryptoAmount) {
        this.cryptoAmount = cryptoAmount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public long getIdUser() {
        return idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public long getIdWallet() {
        return idWallet;
    }
    public void setIdWallet(long idWallet) {
        this.idWallet = idWallet;
    }
    public Double getAvgBuyPrice() {
        return avgBuyPrice;
    }
    public void setAvgBuyPrice(Double avgBuyPrice) {
        this.avgBuyPrice = avgBuyPrice;
    }

    public String getCryptoId() {
        return cryptoId;
    }
    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
    }


}
