package com.example.LuckyOkoedionspringmvccreditshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Order(-1)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            "/register-admin",
            "/admin-login",
            "/show-product-image",
            "/register-customer",
            "/login-customer",
            "/shop",
            "/checkout",
            "/add-product-to-cart"
    };


    @Resource
    private CustomUserDetailsService adminDetailsService;



//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .csrf()
                 .disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/customer/**").hasAuthority("USER")
                .and()
                .formLogin()
                .and()
                .logout();
    }

}
