package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public CreditEntity update(CreditEntity theObj) {
        return creditRepo.save(theObj);
    }

    @Override
    public void subtractValueFromCreditEntityAvailableCreditValueForCustomer(BigDecimal valueToSubtract,
            Long customerId, String transaction_id) {
        CreditEntity record = creditRepo.findByCustomerId(customerId);
        BigDecimal oldCredit = record.getAvailable_credit();
        BigDecimal newCredit = oldCredit.subtract(valueToSubtract);
        creditRepo.updateSingleCustomersCredit(newCredit, customerId);
    }

    @Override
    public CreditEntity getOneByCustomerId(Long customerId) {
        return creditRepo.findByCustomerId(customerId);
    }

    @Override
    public void destroy(Long id) {
        creditRepo.deleteById(id);
    }

    @Override
    public void updateAllCustomersCredit(BigDecimal newCredit) {
        creditRepo.updateAllCustomersCredit(newCredit);

    }

    @Override
    public void updateAllCustomersCreditByPercentage(Integer percentage) {
        creditRepo.updateAllCustomersCreditByPercentage(BigDecimal.valueOf(percentage));
    }

}
