package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletDepositsEntity;

import java.math.BigDecimal;

public interface IWalletDepositsService extends ICrudService<WalletDepositsEntity> {
    Boolean updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAddOrSubtract, Long customerId);
}
