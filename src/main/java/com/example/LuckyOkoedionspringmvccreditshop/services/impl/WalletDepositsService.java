package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletDepositsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.WalletDepositsRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletDepositsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletDepositsService implements IWalletDepositsService {

    private WalletDepositsRepository walletDepositsRepo;

    public WalletDepositsService(WalletDepositsRepository theWalletDepositsRepo) {
        super();
        this.walletDepositsRepo = theWalletDepositsRepo;
    }


    @Override
    public List<WalletDepositsEntity> getAll() {
        return null;
    }

    @Override
    public WalletDepositsEntity create(WalletDepositsEntity theObj) {
        return null;
    }

    @Override
    public WalletDepositsEntity getOneById(Long id) {
        return null;
    }

    @Override
    public WalletDepositsEntity updateStudent(WalletDepositsEntity theObj) {
        return null;
    }

    @Override
    public void destroy(Long id) {

    }

    @Override
    public Boolean updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAddOrSubtract, Long customerId) {
        return null;
    }
}
