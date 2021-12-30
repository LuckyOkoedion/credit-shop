package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
    @Query("select c from CustomersEntity c where c.email = :theEmail")
    CustomersEntity findByEmail(@Param("theEmail") String theEmail);
}
