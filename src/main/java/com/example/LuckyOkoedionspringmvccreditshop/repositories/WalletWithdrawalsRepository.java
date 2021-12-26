package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.WalletWithdrawalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletWithdrawalsRepository extends JpaRepository<WalletWithdrawalsEntity, Long> {
}
