package com.alibou.security.model;

import jakarta.persistence.Column;

public class SoldeSUM {


     private String crypto;

    private Double solde;

     public String getCrypto() {
          return crypto;
     }

     public void setCrypto(String crypto) {
          this.crypto = crypto;
     }

     public Double getSolde() {
          return solde;
     }

     public void setSolde(Double solde) {
          this.solde = solde;
     }

     public SoldeSUM(String crypto, Double solde) {
          this.crypto = crypto;
          this.solde = solde;
     }
}