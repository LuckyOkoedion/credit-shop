package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.WalletWithdrawalsRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IWalletWithdrawalService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletWithdrawalService implements IWalletWithdrawalService {

    private WalletWithdrawalsRepository walletWithdrawalsRepo;

    public  WalletWithdrawalService(WalletWithdrawalsRepository theWalletWithdrawalRepo) {
        super();
        this.walletWithdrawalsRepo = theWalletWithdrawalRepo;
    }


    @Override
    public List<WalletWithdrawalsEntity> getAll() {
        return null;
    }

    @Override
    public WalletWithdrawalsEntity create(WalletWithdrawalsEntity theObj) {
        return null;
    }

    @Override
    public WalletWithdrawalsEntity getOneById(Long id) {
        return null;
    }

    @Override
    public WalletWithdrawalsEntity updateStudent(WalletWithdrawalsEntity theObj) {
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
