package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;

import java.math.BigDecimal;

public interface ICustomerService extends ICrudService <CustomersEntity> {
    CustomersEntity findByEmail(String email);
    Boolean createCreditEntityForCustomer(Long customerId, CreditEntity theObj);
    void subtractValueFromCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToSubtract, Long customerId, String transaction_id);
}
