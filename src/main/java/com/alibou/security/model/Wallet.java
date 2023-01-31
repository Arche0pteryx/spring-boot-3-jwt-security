package com.alibou.security.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "exchangeId")
    private String exchangeId;
    @Column(name = "blockchain")
    private String blockchain;
    @Column(name = "publicKey")
    private String publicKey;

    // Constructor
    public Wallet() {
    }
    public Wallet( long idUser, String name, String exchangeId, String blockchain, String publicKey) {
        super();
        this.idUser = idUser;
        this.name = name;
        this.exchangeId = exchangeId;
        this.blockchain = blockchain;
        this.publicKey = publicKey;
    }
    //  Getters and Setters
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long type) {
        this.idUser = idUser;
    }

    public String getExchangeId() {
        return exchangeId;
    }
    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String type) {
        this.name = name;
    }

    public String getBlockchain() {
        return blockchain;
    }
    public void setBlockchain(String type) {
        this.blockchain = blockchain;
    }

    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

}