package com.example.LuckyOkoedionspringmvccreditshop;

import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository theRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity user = theRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomAdminDetails(user);
    }
}
