package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}
