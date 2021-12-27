package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;

import java.math.BigDecimal;

public interface ICreditService extends ICrudService<CreditEntity> {
    void subtractValueFromCreditEntityAvailableCreditValueForCustomer(BigDecimal valueToSubtract, Long customerId,
            String transaction_id);

    CreditEntity getOneByCustomerId(Long customerId);

    void updateAllCustomersCredit(BigDecimal newCredit);

    void updateAllCustomersCreditByPercentage(Integer percentage);
}
