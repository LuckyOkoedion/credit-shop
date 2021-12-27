package com.example.LuckyOkoedionspringmvccreditshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table
public class WalletDepositsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomersEntity customer;

    @Column
    private Date date;

    @Column
    private String transaction_id;

    @Column
    private BigDecimal amount;

    public WalletDepositsEntity() {

    }

    public WalletDepositsEntity(BigDecimal amount, Date date, CustomersEntity customer, String transaction_id) {
        super();
        this.amount = amount;
        this.customer = customer;
        this.date = date;
        this.transaction_id = transaction_id;

    }

    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WalletDepositsEntity))
            return false;
        return id != null && id.equals(((WalletDepositsEntity) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
