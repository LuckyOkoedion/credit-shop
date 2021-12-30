package com.example.LuckyOkoedionspringmvccreditshop.repositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    @Query("select a from AdminEntity a where a.email = :theEmail")
    AdminEntity findByEmail(@Param("theEmail") String theEmail);
}
