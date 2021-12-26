package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;

import java.math.BigDecimal;

public interface IWalletWithdrawalService extends ICrudService<WalletWithdrawalsEntity> {
    Boolean updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAddOrSubtract, Long customerId);
}
