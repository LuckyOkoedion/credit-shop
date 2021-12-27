package com.example.LuckyOkoedionspringmvccreditshop;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomCustomerDetailsService implements UserDetailsService  {
    @Autowired
    private CustomersRepository theRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomersEntity user = theRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomCustomerDetails(user);
    }
}
