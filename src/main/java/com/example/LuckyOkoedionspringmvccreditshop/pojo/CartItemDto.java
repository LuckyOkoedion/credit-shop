package com.example.LuckyOkoedionspringmvccreditshop.pojo;

import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;

import java.math.BigDecimal;

public class CartItemDto {
    private  ProductEntity product;
    private Integer quantity;
    private BigDecimal subtotal;

    public CartItemDto() {

    }

    public CartItemDto(ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = BigDecimal.valueOf(quantity).multiply(product.getAmount());
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
