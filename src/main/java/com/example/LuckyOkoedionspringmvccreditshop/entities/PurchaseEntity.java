package com.example.LuckyOkoedionspringmvccreditshop.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomersEntity customer;
    @Column
    private Date date;
    @Column
    private String paid_by_credit_or_wallet;

    public PurchaseEntity() {

    }

    public PurchaseEntity(ProductEntity product, CustomersEntity customer, Date date, String paid_by_credit_or_wallet) {
        super();
        this.customer = customer;
        this.product = product;
        this.date = date;
        this.paid_by_credit_or_wallet = paid_by_credit_or_wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PurchaseEntity))
            return false;
        return id != null && id.equals(((PurchaseEntity) o).getId());
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaid_by_credit_or_wallet() {
        return paid_by_credit_or_wallet;
    }

    public void setPaid_by_credit_or_wallet(String paid_by_credit_or_wallet) {
        this.paid_by_credit_or_wallet = paid_by_credit_or_wallet;
    }

}
