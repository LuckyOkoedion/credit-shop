package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseByCreditService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentByCreditService implements IPurchaseByCreditService {

    private CreditService creditService;

    public PaymentByCreditService(CreditService theCreditService) {
        super();
        this.creditService = theCreditService;
    }

    @Override
    public void pay(BigDecimal amount, Long customerId) {

    }
}
