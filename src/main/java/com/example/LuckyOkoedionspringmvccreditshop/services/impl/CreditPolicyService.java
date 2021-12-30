package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditPolicyEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditPolicyRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditPolicyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditPolicyService implements ICreditPolicyService {

    private CreditPolicyRepository creditPolicyRepo;

    public CreditPolicyService(CreditPolicyRepository theCreditPolicyRepo) {
        super();
        this.creditPolicyRepo = theCreditPolicyRepo;
    }


    @Override
    public List<CreditPolicyEntity> getAll() {

        return creditPolicyRepo.findAll();
    }

    @Override
    public CreditPolicyEntity create(CreditPolicyEntity theObj) {
        Long numberOfEnteries = this.creditPolicyRepo.count();
        if ((numberOfEnteries == null) || ( numberOfEnteries < 1)) {
            return creditPolicyRepo.save(theObj);
        } else {
            return new CreditPolicyEntity();
        }

    }

    @Override
    public CreditPolicyEntity getOneById(Long id) {
        return creditPolicyRepo.getById(id);
    }

    @Override
    public CreditPolicyEntity update(CreditPolicyEntity theObj) {
        return creditPolicyRepo.save(theObj);
    }


    @Override
    public void destroy(Long id) {
        creditPolicyRepo.deleteById(id);
    }
}
