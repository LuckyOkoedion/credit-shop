package com.example.LuckyOkoedionspringmvccreditshop;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        if (username.isEmpty() || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public CustomUserDetails(Builder<?> builder) {
        if (builder.username.isEmpty() || (builder.password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.username = builder.username;
        this.password = builder.password;
        this.authorities = builder.authorities;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDetails) {
            return username.equals(((UserDetails) obj).getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    public static class Builder<T extends Builder<?>>{

        private String username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        public Builder(){}

        @SuppressWarnings("unchecked")
        public T getThis(){
            return (T) this;
        }

        public T username(String username){
            this.username = username;
            return getThis();
        }

        public T password(String password){
            this.password = password;
            return getThis();
        }

        public T authorities(Collection<? extends GrantedAuthority>  authorities){
            this.authorities = authorities;
            return getThis();
        }

        public T authorities(GrantedAuthority...authorities) {
            return authorities(Arrays.asList(authorities));
        }

        public T authorities(String... authorities) {
            return authorities(AuthorityUtils.createAuthorityList(authorities));
        }



        public CustomUserDetails build(){
            return new CustomUserDetails(this);
        }

    }
}
