package com.example.LuckyOkoedionspringmvccreditshop.services.impl;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseByWalletService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletWithdrawalService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Service
public class PaymentByWalletService implements IPurchaseByWalletService {
    private ICustomerService customerService;
    private IWalletWithdrawalService walletWithdrawalService;

    public PaymentByWalletService(CustomerService theCustomerService, WalletWithdrawalService theWalletWithdrawalService, CreditService theCreditService) {
        super();
        this.customerService = theCustomerService;
        this.walletWithdrawalService = theWalletWithdrawalService;
    }

    @Override
    public void pay(BigDecimal amount, Long customerId, String transaction_id) {
        CustomersEntity theCustomer = customerService.getOneById(customerId);
        Instant theTime = ZonedDateTime.now(
            ZoneId.of("Africa/Lagos")
        ).toInstant();

        Date currentTime = (Date) Date.from(theTime);

        // record wallet withdrawal

        WalletWithdrawalsEntity theWithdrawal = new WalletWithdrawalsEntity();
        theWithdrawal.setCustomer(theCustomer);
        theWithdrawal.setDate(currentTime);
        theWithdrawal.setAmount(amount);
        theWithdrawal.setTransaction_id(transaction_id);
        walletWithdrawalService.create(theWithdrawal);

        // update wallet balance in user entity

       walletWithdrawalService.updateCustomersEntityWalletBallanceValue(amount, customerId);
        
        // update wallet balance in credit entity

        walletWithdrawalService.updateCreditEntityWalletBallanceValueForCustomer(amount, customerId);

        

    }
}
