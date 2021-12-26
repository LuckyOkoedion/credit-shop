package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.ProductRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepo;

    public ProductService(ProductRepository theProductRepo) {
        super();
        this.productRepo = theProductRepo;
    }


    @Override
    public List<ProductEntity> getAll() {
        return null;
    }

    @Override
    public ProductEntity create(ProductEntity theObj) {
        return null;
    }

    @Override
    public ProductEntity getOneById(Long id) {
        return null;
    }

    @Override
    public ProductEntity updateStudent(ProductEntity theObj) {
        return null;
    }

    @Override
    public void destroy(Long id) {

    }
}
