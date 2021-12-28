package com.example.LuckyOkoedionspringmvccreditshop.pojo;

import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDto {
    private List<CartItemDto> products = new ArrayList<>();;
    private String transaction_id;
    private  BigDecimal grandtotal;

    public PurchaseDto() {

    }

    public PurchaseDto(String transaction_id, List<CartItemDto> products) {
        this.products = products;
        this.transaction_id = transaction_id;
        this.grandtotal = products.stream()
                .map(CartItemDto::getSubtotal)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

    }

    public void addProducts(CartItemDto item) {
        products.add(item);
    }

    public void removeProducts(CartItemDto item) {
        products.remove(item);
    }

    public List<CartItemDto> getProducts() {
        return products;
    }

    public BigDecimal getGrandtotal() {
        return grandtotal;
    }

    public void setProducts(List<CartItemDto> products) {
        this.products = products;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}
