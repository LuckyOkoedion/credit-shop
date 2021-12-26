package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.math.BigDecimal;

public interface IWalletBallanceService {
    BigDecimal getWalletBallance(Long customerId);
}
