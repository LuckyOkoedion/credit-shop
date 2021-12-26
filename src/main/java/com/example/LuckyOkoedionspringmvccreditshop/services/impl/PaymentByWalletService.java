package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseByWalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentByWalletService implements IPurchaseByWalletService {
    private CustomerService customerService;
    private WalletWithdrawalService walletWithdrawalService;

    public PaymentByWalletService(CustomerService theCustomerService, WalletWithdrawalService theWalletWithdrawalService) {
        super();
        this.customerService = theCustomerService;
        this.walletWithdrawalService = theWalletWithdrawalService;
    }

    @Override
    public void pay(BigDecimal amount, Long customerId) {

    }
}
