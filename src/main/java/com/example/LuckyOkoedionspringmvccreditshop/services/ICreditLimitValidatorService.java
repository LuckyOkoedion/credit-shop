package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.math.BigDecimal;

public interface ICreditLimitValidatorService {
    Boolean isThereSufficientCredit(BigDecimal amount, Long customerId);
}
