package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
