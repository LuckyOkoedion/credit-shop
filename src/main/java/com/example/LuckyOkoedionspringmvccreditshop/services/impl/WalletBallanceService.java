package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletBallanceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletBallanceService implements IWalletBallanceService {
    private ICustomerService customersService;

    public WalletBallanceService(CustomerService theCustomerService) {
        super();
        this.customersService = theCustomerService;
    }

    @Override
    public BigDecimal getWalletBallance(Long customerId) {
        CustomersEntity theCustomer = customersService.getOneById(customerId);
        return theCustomer.getWallet_ballance();

    }
}
