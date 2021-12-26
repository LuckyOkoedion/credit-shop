package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.repositories.AdminRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import org.springframework.stereotype.Service;
import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private AdminRepository adminRepo;

    public AdminService(AdminRepository theAdminRepo) {
        super();
        this.adminRepo = theAdminRepo;
    }


    @Override
    public List<AdminEntity> getAll() {
        return adminRepo.findAll();
    }

    @Override
    public AdminEntity create(AdminEntity theObj) {
        return adminRepo.save(theObj);
    }

    @Override
    public AdminEntity getOneById(Long id) {
        return adminRepo.getById(id);
    }

    @Override
    public AdminEntity updateStudent(AdminEntity theObj) {
        return adminRepo.save(theObj);
    }


    @Override
    public void destroy(Long id) {
        adminRepo.deleteById(id);
    }
}
