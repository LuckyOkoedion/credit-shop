package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.WalletWithdrawalsRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletWithdrawalService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletWithdrawalService implements IWalletWithdrawalService {

    private WalletWithdrawalsRepository walletWithdrawalsRepo;
    private ICreditService creditService;
    private ICustomerService customerService;

    public WalletWithdrawalService(WalletWithdrawalsRepository theWalletWithdrawalRepo,
            CustomerService theCustomerService,
            CreditService theCreditService) {
        super();
        this.walletWithdrawalsRepo = theWalletWithdrawalRepo;
        this.creditService = theCreditService;
        this.customerService = theCustomerService;
    }

    @Override
    public List<WalletWithdrawalsEntity> getAll() {
        return walletWithdrawalsRepo.findAll();
    }

    @Override
    public WalletWithdrawalsEntity create(WalletWithdrawalsEntity theObj) {
        return walletWithdrawalsRepo.save(theObj);
    }

    @Override
    public WalletWithdrawalsEntity getOneById(Long id) {
        return walletWithdrawalsRepo.getById(id);
    }

    @Override
    public WalletWithdrawalsEntity update(WalletWithdrawalsEntity theObj) {
        return walletWithdrawalsRepo.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        walletWithdrawalsRepo.deleteById(id);
    }

    @Override
    public void updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToSubtract, Long customerId) {
        CreditEntity theCredit = creditService.getOneByCustomerId(customerId);
        BigDecimal oldWalletBalance = theCredit.getWallet_balance();
        BigDecimal newWalletBalance = oldWalletBalance.subtract(valueToSubtract);
        CreditEntity newCredit = new CreditEntity();
        newCredit.setId(theCredit.getId());
        newCredit.setCustomer(theCredit.getCustomer());
        newCredit.setAvailable_credit(theCredit.getAvailable_credit());
        newCredit.setWallet_balance(newWalletBalance);
        creditService.update(newCredit);
    }

    @Override
    public void updateCustomersEntityWalletBallanceValue(BigDecimal valueToSubtract, Long customerId) {
        CustomersEntity theCustomer = customerService.getOneById(customerId);
        BigDecimal oldWalletBalance = theCustomer.getWallet_ballance();
        BigDecimal newWalletBalance = oldWalletBalance.subtract(valueToSubtract);
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
