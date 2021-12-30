package com.example.LuckyOkoedionspringmvccreditshop.entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private Long source_image_id;
    @Column
    private String description;
    @Column
    private BigDecimal amount;
    @Column
    private int quantity;
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PurchaseEntity> purchase = new ArrayList<>();

    public ProductEntity() {

    }

    public ProductEntity(String name, String brand, Long source_image_id, String description, BigDecimal amount, int quantity, List<PurchaseEntity> purchase ) {
        this.name = name;
        this.brand = brand;
        this.source_image_id = source_image_id;
        this.description = description;
        this.amount = amount;
        this.quantity = quantity;
        this.purchase = purchase;
    }

    public void addPurchase(PurchaseEntity thePurchase) {
        purchase.add(thePurchase);
        thePurchase.setProduct(this);
    }

    public void removePurchase(PurchaseEntity thePurchase) {
        purchase.remove(thePurchase);
        thePurchase.setProduct(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getSource_image_id() {
        return source_image_id;
    }

    public void setSource_image_id(Long source_image_id) {
        this.source_image_id = source_image_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
