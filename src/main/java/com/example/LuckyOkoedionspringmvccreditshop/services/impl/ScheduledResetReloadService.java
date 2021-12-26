package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IScheduledResetReloadService;
import org.springframework.stereotype.Service;

@Service
public class ScheduledResetReloadService implements IScheduledResetReloadService {

    private CreditRepository creditRepo;

    public ScheduledResetReloadService(CreditRepository theCreditRepo) {
        super();
        this.creditRepo = theCreditRepo;
    }

    @Override
    public Boolean setAllCreditToZeroAtReset() {
        return null;
    }

    @Override
    public Boolean setCreditToLimitAtReload(Integer limitPercentage) {
        return null;
    }

}
