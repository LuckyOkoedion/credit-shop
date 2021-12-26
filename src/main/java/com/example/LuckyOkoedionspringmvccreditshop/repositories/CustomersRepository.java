package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
}
