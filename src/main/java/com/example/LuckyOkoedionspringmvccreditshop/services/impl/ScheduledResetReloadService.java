package com.example.LuckyOkoedionspringmvccreditshop.services.impl;
import java.math.BigDecimal;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IScheduledResetReloadService;
import org.springframework.stereotype.Service;

@Service
public class ScheduledResetReloadService implements IScheduledResetReloadService {

    private ICreditService creditService;

    public ScheduledResetReloadService(CreditService theCreditService) {
        super();
        this.creditService = theCreditService;
    }

    @Override
    public void setAllCreditToZeroAtReset() {
        BigDecimal theValue = new BigDecimal("0");
        creditService.updateAllCustomersCredit(theValue);
    }

    @Override
    public void setCreditToLimitAtReload(Integer limitPercentage) {
        creditService.updateAllCustomersCreditByPercentage(limitPercentage);
    }

}
