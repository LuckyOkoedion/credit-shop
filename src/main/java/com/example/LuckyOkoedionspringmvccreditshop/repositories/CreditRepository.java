package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update CreditEntity c set c.available_credit = :newCredit")
    void updateAllCustomersCredit(@Param("newCredit") BigDecimal newCredit);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update CreditEntity c set c.available_credit = c.wallet_balance * :percentage")
    void updateAllCustomersCreditByPercentage(@Param("percentage") BigDecimal percentage);

    @Query("select c from CreditEntity c where c.customer.id = :customerId")
    CreditEntity findByCustomerId(@Param("customerId") Long customerId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update CreditEntity c set c.available_credit = :newCredit where c.customer.id = :customerId")
    void updateSingleCustomersCredit(@Param("newCredit") BigDecimal newCredit, @Param("customerId") Long customerId);

}
