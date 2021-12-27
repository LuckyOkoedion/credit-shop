package com.example.LuckyOkoedionspringmvccreditshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private CustomersEntity customer;
    @Column
    private BigDecimal available_credit;
    @Column
    private BigDecimal wallet_balance;

    public CreditEntity() {
        this.wallet_balance = new BigDecimal("0");
        this.available_credit = new BigDecimal("0");
    }

    public CreditEntity(CustomersEntity customer, BigDecimal available_credit, BigDecimal wallet_balance) {
        super();
        this.customer = customer;
        this.available_credit = available_credit;
        this.wallet_balance = wallet_balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    public BigDecimal getAvailable_credit() {
        return available_credit;
    }

    public void setAvailable_credit(BigDecimal available_credit) {
        this.available_credit = available_credit;
    }

    public BigDecimal getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(BigDecimal wallet_balance) {
        this.wallet_balance = wallet_balance;
    }
}
