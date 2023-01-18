package com.alibou.security.model;



import jakarta.persistence.*;



import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "cryptocurrencybefore")
    private String cryptoCurrencyBefore;
    @Column(name = "cryptocurrencyamountbefore")
    private Double cryptoCurrencyAmountBefore;
    @Column(name = "cryptocurrencyafter")
    private String cryptoCurrencyAfter;
    @Column(name = "cryptocurrencyamountafter")
    private Double cryptoCurrencyAmountAfter;
    @Column(name = "date")
    private Date date;

    // Constructor
    public Transaction() {
    }
    public Transaction( String type, String cryptoCurrencyBefore, Double cryptoCurrencyAmountBefore, String cryptoCurrencyAfter, Double cryptoCurrencyAmountAfter, Date date) {
        super();
        this.type = type;
        this.cryptoCurrencyBefore = cryptoCurrencyBefore;
        this.cryptoCurrencyAmountBefore = cryptoCurrencyAmountBefore;
        this.cryptoCurrencyAfter = cryptoCurrencyAfter;
        this.cryptoCurrencyAmountAfter = cryptoCurrencyAmountAfter;
        this.date = date;
    }
    //  Getters and Setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCryptoCurrencyBefore() {
        return cryptoCurrencyBefore;
    }
    public void setCryptoCurrencyBefore(String cryptoCurrencyBefore) {
        this.cryptoCurrencyBefore = cryptoCurrencyBefore;
    }
    public Double getCryptoCurrencyAmountBefore() {
        return cryptoCurrencyAmountBefore;
    }
    public void setCryptoCurrencyAmountBefore(Double cryptoCurrencyAmountBefore) {
        this.cryptoCurrencyAmountBefore = cryptoCurrencyAmountBefore;
    }
    public String getCryptoCurrencyAfter() {
        return cryptoCurrencyAfter;
    }
    public void setCryptoCurrencyAfter(String cryptoCurrencyAfter) {
        this.cryptoCurrencyAfter = cryptoCurrencyAfter;
    }
    public Double getCryptoCurrencyAmountAfter() {
        return cryptoCurrencyAmountAfter;
    }
    public void setCryptoCurrencyAmountAfter(Double cryptoCurrencyAmountAfter) {
        this.cryptoCurrencyAmountAfter = cryptoCurrencyAmountAfter;
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


}