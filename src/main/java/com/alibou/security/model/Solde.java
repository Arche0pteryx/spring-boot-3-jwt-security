package com.alibou.security.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="soldes")
public class Solde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iduser")
    private long idUser;

    @Column(name = "idwallet")
    private long idWallet;


    @Column(name = "idtransaction")
    private Integer idTransaction;
    @Column(name = "idasset")
    private Integer idAsset;

    @Column(name = "crypto")
    private String crypto;
    @Column(name = "cryptoid")
    private String cryptoid;

    @Column(name = "soldeachat")
    private Double soldeAchat;

    @Column(name = "valeurachat")
    private Double valeurAchat;

    @Column(name = "soldevente")
    private Double soldeVente;

    @Column(name = "valeurvente")
    private Double valeurVente;

    @Column(name = "avgbuyprice")
    private Double avgBuyPrice;

    @Column(name = "avgsellprice")
    private Double avgSellPrice;

    @Column(name = "solde")
    private Double solde;

    @Column(name = "dateff")
    private Date dateff;

    @Column(name = "datfin")
    private Date datfin;
    public Solde() {
    }
    public Solde(long idUser, long idWallet, Integer idTransaction, Integer idAsset, String crypto, String cryptoid, Double soldeAchat, Double valeurAchat, Double soldeVente, Double valeurVente, Double avgBuyPrice, Double avgSellPrice, Double solde, Date dateff, Date datfin) {
        super();
        this.idUser = idUser;
        this.idWallet = idWallet;
        this.idTransaction = idTransaction;
        this.idAsset = idAsset;
        this.crypto = crypto;
        this.cryptoid = cryptoid;
        this.soldeAchat = soldeAchat;
        this.valeurAchat = valeurAchat;
        this.soldeVente = soldeVente;
        this.valeurVente = valeurVente;
        this.avgBuyPrice = avgBuyPrice;
        this.avgSellPrice = avgSellPrice;
        this.solde = solde;
        this.dateff = dateff;
        this.datfin = datfin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(long idWallet) {
        this.idWallet = idWallet;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Integer getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Integer idAsset) {
        this.idAsset = idAsset;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public String getCryptoid() {
        return cryptoid;
    }

    public void setCryptoid(String cryptoid) {
        this.cryptoid = cryptoid;
    }

    public Double getSoldeAchat() {
        return soldeAchat;
    }

    public void setSoldeAchat(Double soldeAchat) {
        this.soldeAchat = soldeAchat;
    }

    public Double getValeurAchat() {
        return valeurAchat;
    }

    public void setValeurAchat(Double valeurAchat) {
        this.valeurAchat = valeurAchat;
    }

    public Double getSoldeVente() {
        return soldeVente;
    }

    public void setSoldeVente(Double soldeVente) {
        this.soldeVente = soldeVente;
    }

    public Double getValeurVente() {
        return valeurVente;
    }

    public void setValeurVente(Double valeurVente) {
        this.valeurVente = valeurVente;
    }

    public Double getAvgBuyPrice() {
        return avgBuyPrice;
    }

    public void setAvgBuyPrice(Double avgBuyPrice) {
        this.avgBuyPrice = avgBuyPrice;
    }

    public Double getAvgSellPrice() {
        return avgSellPrice;
    }

    public void setAvgSellPrice(Double avgSellPrice) {
        this.avgSellPrice = avgSellPrice;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateff() {
        return dateff;
    }

    public void setDateff(Date dateff) {
        this.dateff = dateff;
    }

    public Date getDatfin() {
        return datfin;
    }

    public void setDatfin(Date datfin) {
        this.datfin = datfin;
    }

    @Override
    public String toString() {
        return "Solde{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idWallet=" + idWallet +
                ", idTransaction=" + idTransaction +
                ", idAsset=" + idAsset +
                ", crypto=" + crypto +
                ", cryptoid=" + cryptoid +
                ", soldeAchat=" + soldeAchat +
                ", valeurAchat=" + valeurAchat +
                ", soldeVente=" + soldeVente +
                ", valeurVente=" + valeurVente +
                ", avgBuyPrice=" + avgBuyPrice +
                ", avgSellPrice=" + avgSellPrice +
                ", solde=" + solde +
                ", dateff=" + dateff +
                ", datfin=" + datfin +
                '}';
    }
}

