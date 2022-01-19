package com.example.LuckyOkoedionspringmvccreditshop;

import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.AdminRepository;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private CustomersRepository customersRepo;

    private   List<GrantedAuthority> theAuthorities = new ArrayList<>();

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity adminDetail = adminRepo.findByEmail(username);
        CustomersEntity customerDetail = customersRepo.findByEmail(username);

        if (adminDetail != null) {
            GrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
            GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ADMIN");

            theAuthorities.add(userAuthority);
            theAuthorities.add(adminAuthority);


            UserDetails adminUser = new CustomUserDetails(adminDetail.getEmail(), adminDetail.getPassword(), theAuthorities);

            return adminUser;
        } else if (customerDetail != null) {
            GrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");

            theAuthorities.add(userAuthority);

            UserDetails customerUser = new CustomUserDetails(customerDetail.getEmail(), customerDetail.getPassword(), theAuthorities);

            return customerUser;
        } else  {
            throw new UsernameNotFoundException(username);
        }


    }

}
