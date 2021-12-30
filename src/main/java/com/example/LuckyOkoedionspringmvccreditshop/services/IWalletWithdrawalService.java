package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;

import java.math.BigDecimal;

public interface IWalletWithdrawalService extends ICrudService<WalletWithdrawalsEntity> {
    void updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueSubtract, Long customerId);
    void updateCustomersEntityWalletBallanceValue(BigDecimal valueSubtract, Long customerId);
}
