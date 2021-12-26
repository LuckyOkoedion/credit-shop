package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;

import java.math.BigDecimal;

public interface ICustomerService extends ICrudService <CustomersEntity> {
    Boolean createCreditEntityForCustomer(Long customerId, CreditEntity theObj);
    Boolean updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAddOrSubtract, Long customerId);
}
