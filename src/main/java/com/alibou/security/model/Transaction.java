package com.alibou.security.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iduser")
    private Long idUser;

    @Column(name = "idwallet")
    private Long idWallet;

    @Column(name = "type")
    private String type;
    @Column(name = "cryptoin")
    private String cryptoIN;

    @Column(name = "cryptoinid")
    private String cryptoINid;
    @Column(name = "cryptoinamount")
    private Double cryptoINamount;

    @Column(name = "cryptoinprice")
    private Double cryptoINprice;
    @Column(name = "cryptoout")
    private String cryptoOUT;

    @Column(name = "cryptooutid")
    private String cryptoOUTid;
    @Column(name = "cryptooutamount")
    private Double cryptoOUTamount;
    @Column(name = "cryptooutprice")
    private Double cryptoOUTprice;
    @Column(name = "cryptofee")
    private String cryptoFEE;

    @Column(name = "cryptofeeid")
    private String cryptoFEEid;
    @Column(name = "cryptofeeamount")
    private Double cryptoFEEamount;
    @Column(name = "date")
    private Date date;

    // Constructor
    public Transaction() {
    }
    public Transaction( Long idUser,long idWallet, String type, String cryptoIN ,String cryptoINid,  Double cryptoINamount, Double cryptoINprice, String cryptoOUT,String cryptoOUTid, Double cryptoOUTamount,Double cryptoOUTprice, Date date, String cryptoFEE,String cryptoFEEid, Double cryptoFEEamount) {
        super();
        this.type = type;
        this.idUser = idUser;
        this.idWallet = idWallet;
        this.cryptoIN = cryptoIN;
        this.cryptoINid = cryptoINid;
        this.cryptoINamount = cryptoINamount;
        this.cryptoINprice = cryptoINprice;
        this.cryptoOUT = cryptoOUT;
        this.cryptoOUTid = cryptoOUTid;
        this.cryptoOUTamount = cryptoOUTamount;
        this.cryptoOUTprice = cryptoOUTprice;
        this.cryptoFEE = cryptoFEE;
        this.cryptoFEEid = cryptoFEEid;
        this.cryptoFEEamount = cryptoFEEamount;
        this.date = date;
    }
    //  Getters and Setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCryptoIN() {
        return cryptoIN;
    }
    public void setCryptoIN(String cryptoIN) {
        this.cryptoIN = cryptoIN;
    }
    public Double getCryptoINamount() {
        return cryptoINamount;
    }
    public void setCryptoINamount(Double cryptoINamount) {
        this.cryptoINamount = cryptoINamount;
    }
    public String getCryptoOUT() {
        return cryptoOUT;
    }
    public void setCryptoOUT(String cryptoOUT) {
        this.cryptoOUT = cryptoOUT;
    }
    public Double getCryptoOUTamount() {
        return cryptoOUTamount;
    }
    public void setCryptoOUTamount(Double cryptoOUTamount) {
        this.cryptoOUTamount = cryptoOUTamount;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCryptoFEE() {
        return cryptoFEE;
    }
    public void setCryptoFEE(String cryptoFEE) {
        this.cryptoFEE = cryptoFEE;
    }
    public Double getCryptoFEEamount() {
        return cryptoFEEamount;
    }
    public void setCryptoFEEamount(Double cryptoFEEamount) {
        this.cryptoFEEamount = cryptoFEEamount;
    }

    public Long getIdWallet() {
        return idWallet;
    }
    public void setIdWallet(Long idWallet) {
        this.idWallet = idWallet;
    }
    public String getCryptoINid() {
        return cryptoINid;
    }
    public void setCryptoINid(String cryptoINid) {
        this.cryptoINid = cryptoINid;
    }
    public Double getCryptoINprice() {
        return cryptoINprice;
    }
    public void setCryptoINprice(Double cryptoINprice) {
        this.cryptoINprice = cryptoINprice;
    }
    public String getCryptoOUTid() {
        return cryptoOUTid;
    }
    public void setCryptoOUTid(String cryptoOUTid) {
        this.cryptoOUTid = cryptoOUTid;
    }
    public Double getCryptoOUTprice() {
        return cryptoOUTprice;
    }
    public void setCryptoOUTprice(Double cryptoOUTprice) {
        this.cryptoOUTprice = cryptoOUTprice;
    }
    public String getCryptoFEEid() {
        return cryptoFEEid;
    }
    public void setCryptoFEEid(String cryptoFEEid) {
        this.cryptoFEEid = cryptoFEEid;
    }

}