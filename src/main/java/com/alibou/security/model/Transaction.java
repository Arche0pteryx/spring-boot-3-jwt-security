package com.alibou.security.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "type")
    private String type;
    @Column(name = "cryptoin")
    private String cryptoIN;
    @Column(name = "cryptoinamount")
    private Double cryptoINamount;
    @Column(name = "cryptoout")
    private String cryptoOUT;
    @Column(name = "cryptooutamount")
    private Double cryptoOUTamount;

    @Column(name = "cryptofee")
    private String cryptoFEE;
    @Column(name = "cryptofeeamount")
    private Double cryptoFEEamount;
    @Column(name = "date")
    private Date date;

    // Constructor
    public Transaction() {
    }
    public Transaction( Long idUser, String type, String cryptoIN , Double cryptoINamount, String cryptoOUT, Double cryptoOUTamount, Date date, String cryptoFEE, Double cryptoFEEamount) {
        super();
        this.type = type;
        this.idUser = idUser;
        this.cryptoIN = cryptoIN;
        this.cryptoINamount = cryptoINamount;
        this.cryptoOUT = cryptoOUT;
        this.cryptoOUTamount = cryptoOUTamount;
        this.cryptoFEE = cryptoFEE;
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
}