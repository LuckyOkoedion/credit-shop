package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseByCreditService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentByCreditService implements IPurchaseByCreditService {

    private ICreditService creditService;

    public PaymentByCreditService(CreditService theCreditService) {
        super();
        this.creditService = theCreditService;
    }

    @Override
    public void pay(BigDecimal amount, Long customerId, String transaction_id) {
        this.creditService.subtractValueFromCreditEntityAvailableCreditValueForCustomer(amount, customerId, transaction_id);
    }
}
