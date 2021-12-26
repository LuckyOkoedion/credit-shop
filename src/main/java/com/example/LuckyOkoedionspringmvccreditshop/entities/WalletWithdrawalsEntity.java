package com.example.LuckyOkoedionspringmvccreditshop.entities;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class WalletWithdrawalsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomersEntity customer;
    @Column
    private String date;
    @Column
    private BigDecimal amount;


    public WalletWithdrawalsEntity() {

    }

    public WalletWithdrawalsEntity( BigDecimal amount, String date, CustomersEntity customer) {
        super();
        this.amount = amount;
        this.customer = customer;
        this.date = date;

    }


    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WalletWithdrawalsEntity )) return false;
        return id != null && id.equals(((WalletWithdrawalsEntity) o).getId());
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
