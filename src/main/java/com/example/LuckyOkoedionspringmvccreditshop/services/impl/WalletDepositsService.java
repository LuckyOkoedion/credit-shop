package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletDepositsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.WalletDepositsRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletDepositsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletDepositsService implements IWalletDepositsService {

    private WalletDepositsRepository walletDepositsRepo;
    private ICreditService creditService;
    private ICustomerService customerService;

    public WalletDepositsService(WalletDepositsRepository theWalletDepositsRepo, CustomerService theCustomerService,
            CreditService theCreditService) {
        super();
        this.walletDepositsRepo = theWalletDepositsRepo;
        this.creditService = theCreditService;
        this.customerService = theCustomerService;
    }

    @Override
    public List<WalletDepositsEntity> getAll() {
        return walletDepositsRepo.findAll();
    }

    @Override
    public WalletDepositsEntity create(WalletDepositsEntity theObj) {
        return walletDepositsRepo.save(theObj);
    }

    @Override
    public WalletDepositsEntity getOneById(Long id) {
        return walletDepositsRepo.getById(id);
    }

    @Override
    public WalletDepositsEntity update(WalletDepositsEntity theObj) {
        return walletDepositsRepo.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        walletDepositsRepo.deleteById(id);
    }

    @Override
    public void updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAdd, Long customerId) {
        CreditEntity theCredit = creditService.getOneByCustomerId(customerId);
        BigDecimal oldWalletBalance = theCredit.getWallet_balance();
        BigDecimal newWalletBalance = oldWalletBalance.add(valueToAdd);
        CreditEntity newCredit = new CreditEntity();
        newCredit.setId(theCredit.getId());
        newCredit.setCustomer(theCredit.getCustomer());
        newCredit.setAvailable_credit(theCredit.getAvailable_credit());
        newCredit.setWallet_balance(newWalletBalance);
        creditService.update(newCredit);

    }

    @Override
    public void updateCustomersEntityWalletBallanceValue(BigDecimal valueToAdd, Long customerId) {
        CustomersEntity theCustomer = customerService.getOneById(customerId);
        BigDecimal oldWalletBalance = theCustomer.getWallet_ballance();
        BigDecimal newWalletBalance = oldWalletBalance.add(valueToAdd);
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
