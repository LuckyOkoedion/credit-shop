package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditLimitValidatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditLimitValidatorService implements ICreditLimitValidatorService {

    private CreditRepository creditRepo;

    public CreditLimitValidatorService(CreditRepository theCreditRepo) {
        super();
        this.creditRepo = theCreditRepo;

    }

    @Override
    public Boolean isThereSufficientCredit(BigDecimal amount, Long customerId) {

        CreditEntity theRecord = creditRepo.findByCustomerId(customerId);
        BigDecimal currentCredit = theRecord.getAvailable_credit();

        if(currentCredit.compareTo(amount) < 0) {
            return false;
        } else {
            return true;
        }

    }
}
