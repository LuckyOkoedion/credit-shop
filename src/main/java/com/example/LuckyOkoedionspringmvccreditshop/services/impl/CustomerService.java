package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CreditRepository;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private CustomersRepository customersRepo;
    private CreditRepository creditRepo;

    public  CustomerService(CustomersRepository theCustomersRepo, CreditRepository theCreditRepo) {
        super();
        this.customersRepo = theCustomersRepo;
        this.creditRepo = theCreditRepo;
    }


    @Override
    public List<CustomersEntity> getAll() {
        return customersRepo.findAll();
    }

    @Override
    public CustomersEntity create(CustomersEntity theObj) {
        return customersRepo.save(theObj);
    }


    @Override
    public CustomersEntity getOneById(Long id) {
        return customersRepo.getById(id);
    }

    @Override
    public CustomersEntity updateStudent(CustomersEntity theObj) {
        return customersRepo.save(theObj);
    }


    @Override
    public void destroy(Long id) {
        customersRepo.deleteById(id);
    }


    @Override
    public Boolean createCreditEntityForCustomer(Long customerId, CreditEntity theObj) {
        CreditEntity result = creditRepo.save(theObj);
        if (result  instanceof CreditEntity) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateCreditEntityWalletBallanceValueForCustomer(BigDecimal valueToAddOrSubtract, Long customerId) {
        return null;
    }
}
