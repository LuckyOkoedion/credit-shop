package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletBallanceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletBallanceService implements IWalletBallanceService {
    private CustomersRepository customersRepo;

    public WalletBallanceService(CustomersRepository theCustomerRepo) {
        super();
        this.customersRepo = theCustomerRepo;
    }

    @Override
    public BigDecimal getWalletBallance(Long customerId) {
        return null;
    }
}
