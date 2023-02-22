package com.alibou.security.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "exchangeid")
    private String exchangeId;
    @Column(name = "blockchain")
    private String blockchain;
    @Column(name = "publickey")
    private String publicKey;

    @Column(name = "date")
    private Date date;

    // Constructor
    public Wallet() {
    }
    public Wallet( Long idUser, String name, String exchangeId, String blockchain, String publicKey, Date date) {
        super();
        this.idUser = idUser;
        this.name = name;
        this.exchangeId = exchangeId;
        this.blockchain = blockchain;
        this.publicKey = publicKey;
        this.date = date;
    }
    //  Getters and Setters
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
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
    public void setName(String name) {
        this.name = name;
    }

    public String getBlockchain() {
        return blockchain;
    }
    public void setBlockchain(String blockchain) {
        this.blockchain = blockchain;
    }

    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}