package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService implements ICreditService {

    private CreditRepository creditRepo;

    public CreditService(CreditRepository theCreditRepo) {
        super();
        this.creditRepo = theCreditRepo;
    }


    @Override
    public List<CreditEntity> getAll() {
        return creditRepo.findAll();
    }

    @Override
    public CreditEntity create(CreditEntity theObj) {
        return creditRepo.save(theObj);
    }

    @Override
    public CreditEntity getOneById(Long id) {
        return creditRepo.getById(id);
    }

    @Override
    public CreditEntity updateStudent(CreditEntity theObj) {
        return creditRepo.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        creditRepo.deleteById(id);
    }
}
