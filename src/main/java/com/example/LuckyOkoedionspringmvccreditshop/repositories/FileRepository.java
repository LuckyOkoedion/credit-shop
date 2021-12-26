package com.example.LuckyOkoedionspringmvccreditshop.repositories;

import com.example.LuckyOkoedionspringmvccreditshop.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, String> {
}
