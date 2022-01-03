package com.example.LuckyOkoedionspringmvccreditshop;

public interface ISecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
