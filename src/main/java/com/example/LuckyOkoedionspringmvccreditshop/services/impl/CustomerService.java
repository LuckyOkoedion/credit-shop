package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditService;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private CustomersRepository customersRepo;
    private ICreditService creditService;

    public  CustomerService(CustomersRepository theCustomersRepo, CreditService theCreditService) {
        super();
        this.customersRepo = theCustomersRepo;
        this.creditService = theCreditService;
    }


    @Override
    public List<CustomersEntity> getAll() {
        return customersRepo.findAll();
    }

    @Override
    public CustomersEntity create(CustomersEntity theObj) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(theObj.getPassword());
        theObj.setPassword(encodedPassword);
        return customersRepo.save(theObj);
    }


    @Override
    public CustomersEntity getOneById(Long id) {
        return customersRepo.getById(id);
    }

    @Override
    public CustomersEntity update(CustomersEntity theObj) {
        return customersRepo.save(theObj);
    }


    @Override
    public void destroy(Long id) {
        customersRepo.deleteById(id);
    }


    @Override
    public Boolean createCreditEntityForCustomer(Long customerId, CreditEntity theObj) {
        CreditEntity result = creditService.create(theObj);
        if (result  instanceof CreditEntity) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void subtractValueFromCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToSubtract, Long customerId, String transaction_id) {
        creditService.subtractValueFromCreditEntityAvailableCreditValueForCustomer(valueToSubtract, customerId, transaction_id);
    }


    @Override
    public CustomersEntity findByEmail(String email) {
        return customersRepo.findByEmail(email);
    }


}
