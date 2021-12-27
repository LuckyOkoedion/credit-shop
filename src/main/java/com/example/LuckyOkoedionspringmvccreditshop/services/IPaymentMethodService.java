package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.math.BigDecimal;

public interface IPaymentMethodService {
    void pay(BigDecimal amount, Long customerId, String transaction_id);
}
