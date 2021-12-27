package com.example.LuckyOkoedionspringmvccreditshop.services.impl;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseByWalletService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletWithdrawalService;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


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
        BigDecimal currentWalletBalance = theCustomer.getWallet_ballance();
        BigDecimal newWalletBalance = currentWalletBalance.subtract(amount);
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
        
        CustomersEntity newCustomer = new CustomersEntity();
        newCustomer.setId(theCustomer.getId());
        newCustomer.setFirst_name(theCustomer.getFirst_name());
        newCustomer.setLast_name(theCustomer.getLast_name());
        newCustomer.setEmail(theCustomer.getEmail());
        newCustomer.setPassword(theCustomer.getPassword());
        newCustomer.setCredit_card_number(theCustomer.getCredit_card_number());
        newCustomer.setCredit_card_type(theCustomer.getCredit_card_type());
        newCustomer.setWallet_ballance(newWalletBalance);
        newCustomer.setCredit_card_expiration(theCustomer.getCredit_card_expiration());
        newCustomer.setCredit(theCustomer.getCredit());
        newCustomer.setWallet_deposits(theCustomer.getWallet_deposits());
        newCustomer.setWallet_withdrawals(theCustomer.getWallet_withdrawals());
        newCustomer.setPurchase(theCustomer.getPurchase());
        newCustomer.setCredit_card_bank(theCustomer.getCredit_card_bank());
        customerService.update(newCustomer);
        

    }
}
