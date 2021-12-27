package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.PurchaseRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {

    private PurchaseRepository purchaseRepo;

    public PurchaseService(PurchaseRepository thePurchaseRepo) {
        super();
        this.purchaseRepo = thePurchaseRepo;
    }


    @Override
    public List<PurchaseEntity> getAll() {
        return purchaseRepo.findAll();
    }

    @Override
    public PurchaseEntity create(PurchaseEntity theObj) {
        return purchaseRepo.save(theObj);
    }

    @Override
    public PurchaseEntity getOneById(Long id) {
        return purchaseRepo.getById(id);
    }

    @Override
    public PurchaseEntity update(PurchaseEntity theObj) {
        return purchaseRepo.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        purchaseRepo.deleteById(id);
    }
}
