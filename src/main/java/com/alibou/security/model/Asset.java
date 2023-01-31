package com.alibou.security.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="assets")
public class Asset {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private long idUser;

    @Column(name = "crypto")
    private String crypto;

    @Column(name = "cryptoamount")
    private Double cryptoAmount;
    @Column(name = "date")
    private Date date;

    // Constructor
    public Asset() {
    }
    public Asset(long idUser, String crypto, Double cryptoAmount, Date date) {
        super();
        this.idUser = idUser;
        this.crypto = crypto;
        this.cryptoAmount = cryptoAmount;
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


}
